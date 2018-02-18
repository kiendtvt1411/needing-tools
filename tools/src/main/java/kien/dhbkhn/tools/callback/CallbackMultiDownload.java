package kien.dhbkhn.tools.callback;

import java.util.List;

import kien.dhbkhn.tools.data.download.DefaultDownload;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface CallbackMultiDownload<F extends DefaultDownload> extends CallbackError {

    void downloadSuccessPart(int curPos, List<F> dataList);

    void downloadSuccessAll(List<F> dataList);

    void downloadFailure();
}
