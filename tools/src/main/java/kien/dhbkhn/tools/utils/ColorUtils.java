package kien.dhbkhn.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by KienDepTrai on 25/01/2018.
 */

public final class ColorUtils {

    private static String convertColorToString(Context context, int idColor) {
        return "#" + Integer.toHexString(ContextCompat.getColor(context, idColor));
    }

    public static int convertResourceToColor(Context context, int idColor) {
        String hexColor = convertColorToString(context, idColor);
        return Color.parseColor(hexColor);
    }

    public static void changeStatusBarColor(Activity activity, int colorId) {
        Window window = activity.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(activity, colorId));
        }
    }
}
