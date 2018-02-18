package kien.dhbkhn.tools.data.preference;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface IToolPrefHelper {

    <D> void saveData(String title, D data);

    <D> D getData(String title, Class<D> dClass);

    void saveDataString(String title, String data);

    String getDataString(String title);

    void saveDataInt(String title, int data);

    int getDataInt(String title);

    void saveDataBoolean(String title, boolean data);

    boolean getDataBoolean(String title);

    void saveDataFloat(String title, float data);

    float getDataFloat(String title);
}
