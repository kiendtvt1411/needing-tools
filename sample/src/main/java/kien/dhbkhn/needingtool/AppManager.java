package kien.dhbkhn.needingtool;

import android.app.Application;

import io.reactivex.Observable;
import kien.dhbkhn.needingtool.server.ComicsByType;
import kien.dhbkhn.needingtool.server.ServiceComicInfo;
import kien.dhbkhn.tools.callback.CallbackDataRetrofit;
import kien.dhbkhn.tools.data.network.IToolApiHelper;
import kien.dhbkhn.tools.data.network.ToolApiHelper;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public class AppManager {

    private static AppManager instance;

    private IToolApiHelper iToolApiHelper;

    public static AppManager getInstance() {
        return instance;
    }

    private AppManager(Application application) {
        iToolApiHelper = new ToolApiHelper();
    }

    public static void from(Application application) {
        if(instance == null)
            instance = new AppManager(application);
    }

    public void getAllComicWithTypeId(int typeId, int limit, CallbackDataRetrofit<ComicsByType> callback) {
        String id = String.valueOf(typeId);
        ServiceComicInfo service = iToolApiHelper.getServiceApi(ServiceComicInfo.class, "http://mr.aonhub.com/apiv1/");
        Observable<ComicsByType> observable = service.createService(id, limit);
        iToolApiHelper.addService(observable, callback);
    }
}
