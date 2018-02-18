package kien.dhbkhn.tools.ui;

import android.view.View;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface IBaseFragment {

    void initFragment(View view);

    void setup(View view);

    void getData();

    void updateUI();

    void releaseData();
}
