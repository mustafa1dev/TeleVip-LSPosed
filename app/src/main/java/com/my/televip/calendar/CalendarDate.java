package com.my.televip.calendar;

import com.my.televip.language.Keys;
import com.my.televip.language.Translator;

import java.time.chrono.HijrahDate;
import java.time.temporal.ChronoField;

import ir.huri.jcal.JalaliCalendar;

public class CalendarDate {

    private final int year;
    private final int month;
    private final String monthName;
    private final int day;

    public CalendarDate(HijrahDate hijrahDate) {
        day = hijrahDate.get(ChronoField.DAY_OF_MONTH);
        month = hijrahDate.get(ChronoField.MONTH_OF_YEAR);
        year = hijrahDate.get(ChronoField.YEAR);
        String[] hijriMonths = { Translator.get(Keys.HijriMonthMuharram), Translator.get(Keys.HijriMonthSafar), Translator.get(Keys.HijriMonthRabiAlAwal), Translator.get(Keys.HijriMonthRabiAlThani), Translator.get(Keys.HijriMonthJumadaAlAwal), Translator.get(Keys.HijriMonthJumadaAlThani), Translator.get(Keys.HijriMonthRajab), Translator.get(Keys.HijriMonthShaban), Translator.get(Keys.HijriMonthRamadan), Translator.get(Keys.HijriMonthShawwal), Translator.get(Keys.HijriMonthDhulQidah), Translator.get(Keys.HijriMonthDhulHijjah) };
        monthName = hijriMonths[month - 1];
    }

    public CalendarDate(JalaliCalendar jalaliCalendar) {
        year = jalaliCalendar.getYear();
        month = jalaliCalendar.getMonth();
        day = jalaliCalendar.getDay();
        String[] persianMonths = { Translator.get(Keys.PersianMonthFarvardin), Translator.get(Keys.PersianMonthOrdibehesht), Translator.get(Keys.PersianMonthKhordad), Translator.get(Keys.PersianMonthTir), Translator.get(Keys.PersianMonthMordad), Translator.get(Keys.PersianMonthShahrivar), Translator.get(Keys.PersianMonthMehr), Translator.get(Keys.PersianMonthAban), Translator.get(Keys.PersianMonthAzar), Translator.get(Keys.PersianMonthDey), Translator.get(Keys.PersianMonthBahman), Translator.get(Keys.PersianMonthEsfand)};
        monthName = persianMonths[month - 1];
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthName() {
        return monthName;
    }
}
