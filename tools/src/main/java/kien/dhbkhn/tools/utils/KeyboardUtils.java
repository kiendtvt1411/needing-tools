package kien.dhbkhn.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/**
 * Created by KienDepTrai on 24/01/2018.
 */

public final class KeyboardUtils {

    private KeyboardUtils() {

    }

    /**
     * Open edit text or auto search complete text and keyboard
     *
     * @param activity activity contain that edit text
     * @param editView View can edit (EditText, AutoCompleteTextView, ...)
     */
    public static void openKeyboard(Activity activity, View editView) {
        editView.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editView, InputMethodManager.HIDE_IMPLICIT_ONLY);
        if (editView instanceof EditText) {
            ((EditText) editView).setCursorVisible(true);
        } else if (editView instanceof AutoCompleteTextView) {
            ((AutoCompleteTextView) editView).setCursorVisible(true);
        }
        showKeyboard(activity);
    }

    /**
     * Hide edit text or auto search complete text and keyboard
     *
     * @param activity activity contain that edit text
     * @param editView View can edit (EditText, AutoCompleteTextView, ...)
     */
    public static void closeKeyboard(Activity activity, View editView) {
        if (editView instanceof EditText) {
            ((EditText) editView).setCursorVisible(false);
        } else if (editView instanceof AutoCompleteTextView) {
            ((AutoCompleteTextView) editView).setCursorVisible(false);
        }
        hideSoftInput(activity);
    }

    private static void showKeyboard(Activity activity) {
        activity.getWindow()
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public static void hideSoftInput(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftInput(EditText edit, Context context) {
        edit.setFocusable(true);
        edit.setFocusableInTouchMode(true);
        edit.requestFocus();

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        imm.showSoftInput(edit, 0);
    }

    public static void toggleSoftInput(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
