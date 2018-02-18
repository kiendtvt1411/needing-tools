package kien.dhbkhn.tools.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public final class PermissionUtils {

    /**
     * Check permission has been granted yet
     *
     * @param context    activity where you want to request permission in
     * @param typePermit permission which you want
     * @return true if permisson granted
     * <br> false if not granted
     */
    public static boolean isPermissionGranted(Activity context, String typePermit) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(typePermit)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                return false;
            }
        } else {
            //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

    /**
     * Request permission from user
     *
     * @param context    activity where you want to request permission in
     * @param typePermit permission which you want
     * @param codePermit code refer to that typePermit
     */
    public static void requestPermission(Activity context, String typePermit, int codePermit) {
        ActivityCompat.requestPermissions(context,
                new String[]{typePermit},
                codePermit);
    }

    /**
     * Request multi permission with only once time request
     *
     * @param context     activity where you want to request permission in
     * @param typePermits array of permissions which you want
     * @param codeMulti   code refer to the request for those permissions
     */
    public static void requestMultiPermission(Activity context, String[] typePermits, int codeMulti) {
        ActivityCompat.requestPermissions(context,
                typePermits,
                codeMulti);
    }
}
