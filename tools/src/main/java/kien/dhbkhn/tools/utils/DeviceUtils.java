package kien.dhbkhn.tools.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * Created by KienDepTrai on 23/01/2018.
 */

public final class DeviceUtils {

    public static String getTypeOfDevice(){
        return "android";
    }

    public static String getLanguageOfDevice(){
        try {
            return URLEncoder.encode(Locale.getDefault().getDisplayLanguage(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "VN";
        }
    }

    public static String getCountryOfDevice(Context context){
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static String getIdOfDevice(Context context){
        try {
            return URLEncoder.encode(Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "12345abcde";
        }
    }

    public static String getNameOfDevice() {
        try {
            return URLEncoder.encode(android.os.Build.MODEL, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Android Phone";
        }
    }

    public static int getVersionOfCode(Context context){
        int version = 1;
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String versionCode = pInfo.versionName;
            version = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
        return version;
    }
}
