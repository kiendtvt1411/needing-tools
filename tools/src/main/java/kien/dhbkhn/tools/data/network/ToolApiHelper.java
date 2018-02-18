package kien.dhbkhn.tools.data.network;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kien.dhbkhn.tools.callback.CallbackDataRetrofit;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public class ToolApiHelper implements IToolApiHelper {

    public ToolApiHelper() {
    }

    @Override
    public Retrofit getRetrofitImpl(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Override
    public <S> S getServiceApi(Class<S> sClass, String baseUrl) {
        return getRetrofitImpl(baseUrl).create(sClass);
    }

    @Override
    public <D> void addService(Observable<D> observable, CallbackDataRetrofit<D> callback) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<D>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(D d) {
                        if (d != null)
                            callback.getData(d);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.notifyError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
