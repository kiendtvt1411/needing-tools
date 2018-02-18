package kien.dhbkhn.tools.data.download;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;

import java.util.List;

import kien.dhbkhn.tools.callback.CallbackMultiDownload;
import kien.dhbkhn.tools.callback.CallbackSingleDownload;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public interface IToolDownloadHelper<F extends DefaultDownload> {

    BaseDownloadTask createNewTask(F data);

    void downloadSingleFile(F data, CallbackSingleDownload<F> callback);

    void downloadMultiFile(List<F> listData, CallbackMultiDownload<F> callback);

    FileDownloadListener createSingleListener(F data, CallbackSingleDownload<F> callback);

    FileDownloadListener createMultiListener(List<F> listData, CallbackMultiDownload<F> callback);
}
