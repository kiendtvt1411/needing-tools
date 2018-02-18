package kien.dhbkhn.tools.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by KienDepTrai on 24/01/2018.
 */

public final class ToastUtils {

    public static void showNormalToast(View parentView, String message) {
        Snackbar snackbar = Snackbar
                .make(parentView, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public static void showInternetConnectionToast(Context context, ViewGroup parentView, String message, final
                                                   RetryConnection retryConnection) {
        Snackbar snackbar = Snackbar
                .make(parentView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        retryConnection.tryOpenConnection();
                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public static void showWeakConnectionToast(Context context, View parentView, String message, final RetryConnection
                                               retryConnection) {
        Snackbar snackbar = Snackbar
                .make(parentView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        retryConnection.tryOpenConnection();
                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public interface RetryConnection{

        void tryOpenConnection();
    }
}
