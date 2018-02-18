package kien.dhbkhn.tools.ui;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface IBaseActivity {

    void initActivity();

    void setup();

    void getData();

    void updateUI();

    void releaseData();

    void attachFragment(String tag);

    void detachFragment(String tag);
}
