package kien.dhbkhn.tools.data.network;

import io.reactivex.Observable;
import kien.dhbkhn.tools.callback.CallbackDataRetrofit;
import retrofit2.Retrofit;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface IToolApiHelper {

    Retrofit getRetrofitImpl(String baseUrl);

    <S> S getServiceApi(Class<S> sClass, String baseUrl);

    <D> void addService(Observable<D> observable, CallbackDataRetrofit<D> callback);
}
