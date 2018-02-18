package kien.dhbkhn.tools.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public class ToolPrefHelper implements IToolPrefHelper {

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Gson mGson;

    public ToolPrefHelper(String titleName, Context context) {
        mPref = context.getSharedPreferences(titleName, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
        mGson = new Gson();
    }

    @Override
    public <D> void saveData(String title, D data) {
        String dataJson = getDataString(title);
        saveDataString(title, dataJson);
    }

    @Override
    public <D> D getData(String title, Class<D> dClass) {
        String dataJson = getDataString(title);
        return mGson.fromJson(dataJson, dClass);
    }

    @Override
    public void saveDataString(String title, String data) {
        mEditor.putString(title, data);
        mEditor.commit();
    }

    @Override
    public String getDataString(String title) {
        return mPref.getString(title, "{}");
    }

    @Override
    public void saveDataInt(String title, int data) {
        mEditor.putInt(title, data);
        mEditor.commit();
    }

    @Override
    public int getDataInt(String title) {
        return mPref.getInt(title, 0);
    }

    @Override
    public void saveDataBoolean(String title, boolean data) {
        mEditor.putBoolean(title, data);
        mEditor.commit();
    }

    @Override
    public boolean getDataBoolean(String title) {
        return mPref.getBoolean(title, false);
    }

    @Override
    public void saveDataFloat(String title, float data) {
        mEditor.putFloat(title, data);
        mEditor.commit();
    }

    @Override
    public float getDataFloat(String title) {
        return mPref.getFloat(title, 0.0f);
    }
}
