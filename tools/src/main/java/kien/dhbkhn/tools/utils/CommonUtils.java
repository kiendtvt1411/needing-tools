package kien.dhbkhn.tools.utils;

import android.os.Build;
import android.text.Html;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public final class CommonUtils {

    private static final String TAG = "kiendz";

    public static boolean isStringValid(String str) {
        if (str == null)
            return false;
        if (str == "")
            return false;
        if (str.isEmpty())
            return false;
        return true;
    }

    public static void logInformation(String message) {
        if (isStringValid(message))
            Log.e(TAG, message);
        else
            Log.e(TAG, "Null message!");
    }

    /**
     * Format date from old formatter
     * to date: dd/MM/yyyy and HH:mm
     *
     * @param time      date was parsed by old formatter
     * @param oldFormat old formatter type
     * @return new array string
     * <br> string[0] is date formatted
     * <br> string[1] is time formatted
     */
    public static String[] convertToNewDatetime(String time, String oldFormat) {
        if (!isStringValid(time))
            return new String[]{"N/A", "N/A"};
        SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
        Date date;
        try {
            date = sdfOld.parse(time);
        } catch (ParseException e) {
            date = new Date();
            e.printStackTrace();
        }
        SimpleDateFormat sdfDateNew = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfTimeNew = new SimpleDateFormat("HH:mm");
        return new String[]{sdfDateNew.format(date), sdfTimeNew.format(date)};
    }

    /**
     * Format date from old formatter: yyyy-MM-dd HH:mm:ss
     * to date: dd/MM/yyyy and HH:mm
     *
     * @param time date was parsed by old formatter
     * @return new array string
     * <br> string[0] is date formatted
     * <br> string[1] is time formatted
     */
    public static String[] convertToNewDateTime(String time) {
        return convertToNewDatetime(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * According to the time, parse date to string
     * detect day: Today, Tomorrow, Yesterday
     *
     * @param time      date was parsed by old formatter
     * @param oldFormat old formatter type
     *
     * @return string like Today, Tomorrow, Yesterday
     * <br> or Monday, Tuesday, ...
     */
    public static String detectDay(String time, String oldFormat) {
        if (!isStringValid(time))
            return "N/A";
        SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
        Date d;
        try {
            d = sdfOld.parse(time);
        } catch (ParseException e) {
            d = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        String nameDate = "N/A";
        switch (dayOfWeek) {
            case 1:
                nameDate = "Chủ nhật";
                break;
            case 2:
                nameDate = "Thứ hai";
                break;
            case 3:
                nameDate = "Thứ ba";
                break;
            case 4:
                nameDate = "Thứ tư";
                break;
            case 5:
                nameDate = "Thứ năm";
                break;
            case 6:
                nameDate = "Thứ sáu";
                break;
            case 7:
                nameDate = "Thứ bảy";
                break;
        }
        // get calendar current
        Date date = new Date();
        c.setTime(date);
        int dayOfMonthNow = c.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat sdfNew = new SimpleDateFormat("MM/yyyy");
        if (sdfNew.format(date).equalsIgnoreCase(sdfNew.format(d))) {
            if (dayOfMonthNow == dayOfMonth)
                nameDate = "Hôm nay";
            else if (dayOfMonthNow == dayOfMonth - 1)
                nameDate = "Ngày mai";
            else if (dayOfMonthNow == dayOfMonth + 1)
                nameDate = "Hôm qua";
        }

        return nameDate;
    }

    /**
     * According to the time, parse date to string
     * detect day: Today, Tomorrow, Yesterday
     *
     * @param time      date was parsed by old formatter
     * <br> with default old format yyyy-MM-dd HH:mm:ss
     * @return string like Today, Tomorrow, Yesterday
     * <br> or Monday, Tuesday, ...
     */
    public static String detectDay(String time) {
        if (!isStringValid(time))
            return "N/A";
        SimpleDateFormat sdfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try {
            d = sdfOld.parse(time);
        } catch (ParseException e) {
            d = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        String nameDate = "N/A";
        switch (dayOfWeek) {
            case 1:
                nameDate = "Chủ nhật";
                break;
            case 2:
                nameDate = "Thứ hai";
                break;
            case 3:
                nameDate = "Thứ ba";
                break;
            case 4:
                nameDate = "Thứ tư";
                break;
            case 5:
                nameDate = "Thứ năm";
                break;
            case 6:
                nameDate = "Thứ sáu";
                break;
            case 7:
                nameDate = "Thứ bảy";
                break;
        }
        // get calendar current
        Date date = new Date();
        c.setTime(date);
        int dayOfMonthNow = c.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat sdfNew = new SimpleDateFormat("MM/yyyy");
        if (sdfNew.format(date).equalsIgnoreCase(sdfNew.format(d))) {
            if (dayOfMonthNow == dayOfMonth)
                nameDate = "Hôm nay";
            else if (dayOfMonthNow == dayOfMonth - 1)
                nameDate = "Ngày mai";
            else if (dayOfMonthNow == dayOfMonth + 1)
                nameDate = "Hôm qua";
        }

        return nameDate;
    }

    public static String getCodeConnect(int codeId) {
        switch (codeId) {
            case 200:
                return "OK";
            case 201:
                return "CREATED";
            case 204:
                return "NO CONTENT";
            case 304:
                return "NOT MODIFIED";
            case 400:
                return "BAD REQUEST";
            case 401:
                return "UNAUTHORIZED";
            case 403:
                return "FORBIDDEN";
            case 404:
                return "NOT FOUND";
            case 405:
                return "METHOD NOT ALLOWED";
            case 409:
                return "CONFLICT";
            case 500:
                return "INTERNAL SERVER ERROR";
            default:
                return "NOT FOUND CODE";
        }
    }

    public static String parserHtmlToString(String htmlText) {
        if(!isStringValid(htmlText)) return "N/A";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(htmlText).toString();
        }
    }

    public static int parseStringDecimalToInteger(String str) {
        if (!isStringValid(str))
            return 0;
        try {
            return Integer.parseInt(str.replaceAll(",",""));
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int parseStringToInteger(String str) {
        if (!isStringValid(str))
            return 0;
        try {
            return Integer.parseInt(str);
        } catch (Exception ex) {
            return 0;
        }
    }
}
