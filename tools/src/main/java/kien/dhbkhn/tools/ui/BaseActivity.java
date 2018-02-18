package kien.dhbkhn.tools.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Initiate activity by following steps:
     * <br> Setup: refer view with id by butter knife bind this view, and setup toolbar, list if need
     * <br> GetData: get data from singleton manager app
     * <br> UpdateUI: update view after have data
     */
    @Override
    public void initActivity() {
        setup();
        getData();
        updateUI();
    }

    /**
     * Don't forget to release data if need in method releaseData()
     */
    @Override
    protected void onDestroy() {
        releaseData();
        super.onDestroy();
    }
}
