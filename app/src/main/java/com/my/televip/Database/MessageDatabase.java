package com.my.televip.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.my.televip.logging.Logger;
import com.my.televip.messages.MessageStorage;

import java.io.File;
import java.util.Calendar;

public class MessageDatabase extends SQLiteOpenHelper {

    private final String TABLE_MESSAGES = "messages";
    private final String COLUMN_ID = "id";
    private final String COLUMN_MSG_ID = "msg_id";
    private final String COLUMN_MESSAGE = "message";
    private final String COLUMN_MESSAGE_DATE = "message_date";
    private final String COLUMN_MSG_COUNT = "msg_count";

    public MessageDatabase(Context context) {
        super(context, getDataBasePath(), null, 1);
    }

    public static String getDataBasePath() {
        return new File(MessageStorage.getStorageFile(), "saveMessages.db").getAbsolutePath();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE = "CREATE TABLE " + TABLE_MESSAGES + " (" +
                COLUMN_ID + " LONG, " +
                COLUMN_MSG_ID + " INTEGER, " +
                COLUMN_MSG_COUNT + " INTEGER, " +
                COLUMN_MESSAGE + " TEXT, " +
                COLUMN_MESSAGE_DATE + " LONG " +
                ");";
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        onCreate(db);
    }

    public void addMessage(long id, int msgID, String message) {
        try {
            MessageStorage.getStorage().post(() -> {
                SQLiteDatabase database = getWritableDatabase();
                if (!searchMessage(id, msgID, message)) {
                    ContentValues values = new ContentValues();
                    values.put(COLUMN_ID, id);
                    values.put(COLUMN_MSG_ID, msgID);
                    values.put(COLUMN_MESSAGE, message);

                    int maxMsgCount = getMaxMessageCount(id, msgID);
                    values.put(COLUMN_MSG_COUNT, maxMsgCount + 1);

                    values.put(COLUMN_MESSAGE_DATE, Calendar.getInstance().getTimeInMillis());

                    database.insert(TABLE_MESSAGES, null, values);
                }
            });
        } catch (Throwable t) {
            Logger.e(t);
        }
    }

    public boolean searchMessage(long id, int msgId, String message) {
        if (message == null) return false;

        try {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_MESSAGES +
                    " WHERE " + COLUMN_ID + " = ? AND " +
                    COLUMN_MSG_ID + " = ? AND " +
                    COLUMN_MESSAGE + " = ? LIMIT 1";
            Cursor cursor = database.rawQuery(query, new String[]{
                    String.valueOf(id),
                    String.valueOf(msgId),
                    message
            });
            boolean exists = cursor.getCount() > 0;
            cursor.close();
            return exists;
        } catch (Throwable t) {
            Logger.e(t);
        }
        return false;
    }

    public boolean searchMessage(long id, int msgId) {
        try {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_MESSAGES +
                    " WHERE " + COLUMN_ID + " = ? AND " +
                    COLUMN_MSG_ID + " = ? LIMIT 1";
            Cursor cursor = database.rawQuery(query, new String[]{
                    String.valueOf(id),
                    String.valueOf(msgId)
            });
            boolean exists = cursor.getCount() > 0;
            cursor.close();
            return exists;
        } catch (Throwable t) {
            Logger.e(t);
        }
        return false;
    }


    public String getMessage(long id, int msgId) {
        try {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT " + COLUMN_MESSAGE + " FROM " + TABLE_MESSAGES +
                    " WHERE " + COLUMN_ID + " = ? AND " + COLUMN_MSG_ID + " = ? LIMIT 1";
            Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(id), String.valueOf(msgId)});
            String message = null;
            if (cursor.moveToFirst()) {
                message = cursor.getString(0);
            }
            cursor.close();
            return message;
        } catch (Throwable t) {
            Logger.e(t);
        }
        return null;
    }

    public String getMessage(long id, int msgID, int msgCount) {
        try {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT " + COLUMN_MESSAGE + " FROM " + TABLE_MESSAGES +
                    " WHERE " + COLUMN_ID + " = ? AND " + COLUMN_MSG_ID + " = ? AND " + COLUMN_MSG_COUNT + " = ? LIMIT 1";
            Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(id), String.valueOf(msgID), String.valueOf(msgCount)});
            String message = null;
            if (cursor.moveToFirst()) {
                message = cursor.getString(0);
            }
            cursor.close();
            return message;
        } catch (Throwable t) {
            Logger.e(t);
        }
        return null;
    }

    public long getMessageDate(long id, int msgID, int msgCount) {
        try {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT " + COLUMN_MESSAGE_DATE + " FROM " + TABLE_MESSAGES +
                    " WHERE " + COLUMN_ID + " = ? AND " + COLUMN_MSG_ID + " = ? AND " + COLUMN_MSG_COUNT + " = ? LIMIT 1";
            Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(id), String.valueOf(msgID), String.valueOf(msgCount)});
            long messageDate = 0;
            if (cursor.moveToFirst()) {
                messageDate = cursor.getLong(0);
            }
            cursor.close();
            return messageDate;
        } catch (Throwable i) {
        }
        return 0;
    }

    public int getMaxMessageCount(long id, int msgID) {
        int maxCount = 0;
        try {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT MAX(" + COLUMN_MSG_COUNT + ") FROM " + TABLE_MESSAGES +
                    " WHERE " + COLUMN_ID + " = ? AND " + COLUMN_MSG_ID + " = ?";
            Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(id), String.valueOf(msgID)});
            if (cursor.moveToFirst()) {
                maxCount = cursor.getInt(0);
            }
            cursor.close();
        } catch (Throwable t) {
            Logger.e(t);
        }
        return maxCount;
    }
}