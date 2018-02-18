package kien.dhbkhn.tools.callback;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface CallbackDataRetrofit<T> extends CallbackError {

    void getData(T data);
}
