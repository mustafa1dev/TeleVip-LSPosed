package com.my.televip.utils;

import static com.my.televip.application.AndroidUtilities.dp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.LinearLayout;

import com.my.televip.language.Keys;
import com.my.televip.language.Translator;
import com.my.televip.virtuals.ActionBar.AlertDialog;
import com.my.televip.virtuals.Theme;
import com.my.televip.virtuals.ui.Cells.RadioColorCell;

public class DialogUtils {

    public static Dialog createSingleChoiceDialog(Activity parentActivity, final String[] options, final String title, final int selected, final DialogInterface.OnClickListener listener) {
        final LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        AlertDialog builder = new AlertDialog(parentActivity);
        for (int a = 0; a < options.length; a++) {
            RadioColorCell cell = new RadioColorCell(parentActivity);
            cell.setPadding(dp(4), 0, dp(4), 0);
            cell.setTag(a);
            cell.setCheckColor(Theme.getTextColor(), Theme.getTextBlueColor());
            cell.setTextAndValue(options[a], selected == a);
            linearLayout.addView(cell);
            cell.setOnClickListener(v -> {
                int sel = (Integer) v.getTag();
                builder.getDismissRunnable().run();
                listener.onClick(null, sel);
            });
        }

        builder.setTitle(title);
        builder.setView(linearLayout);
        builder.setPositiveButton(Translator.get(Keys.Cancel), null);
        return builder.create();
    }

    public static void showQuranAlert(Context context){
        AlertDialog alertDialog = new AlertDialog(context);
        alertDialog.setTitle("TeleVip");
        alertDialog.setMessage(Translator.get(Keys.QuranNotification));
        alertDialog.setPositiveButton(Translator.get(Keys.Done), null);
        alertDialog.show();
    }
}
