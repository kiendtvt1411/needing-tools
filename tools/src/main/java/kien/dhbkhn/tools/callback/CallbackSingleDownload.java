package kien.dhbkhn.tools.callback;

import kien.dhbkhn.tools.data.download.DefaultDownload;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface CallbackSingleDownload<F extends DefaultDownload> extends CallbackError {

    void downloadSuccess(F data);

    void downloadFailure();

    void processDownload(int sofarBytes, int totalBytes);
}
