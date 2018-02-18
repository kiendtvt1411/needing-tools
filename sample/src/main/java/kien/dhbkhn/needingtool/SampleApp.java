package kien.dhbkhn.needingtool;

import android.app.Application;

/**
 * Created by KienDepTrai on 17/02/2018.
 */

public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppManager.from(this);
    }
}
