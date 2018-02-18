package kien.dhbkhn.tools.data.download;

import android.content.Context;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;

import java.util.ArrayList;
import java.util.List;

import kien.dhbkhn.tools.callback.CallbackMultiDownload;
import kien.dhbkhn.tools.callback.CallbackSingleDownload;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public class ToolDownloadHelper<F extends DefaultDownload> implements IToolDownloadHelper<F> {

    /**
     * Must setup SugarContext before use this class download helper
     *
     */
    public ToolDownloadHelper(Context context, Class<F> fClass) {
        FileDownloader.setup(context);
    }

    /**
     * Create new task for downloading
     * <br>But you must check link & path must valid by using CommonUtils.java class
     *
     * @param data data contains some needed information likes link, path, id, status
     */
    @Override
    public BaseDownloadTask createNewTask(F data) {
        data.save();
        return FileDownloader.getImpl()
                .create(data.getLinkDownload())
                .setPath(data.getPathDownload())
                .setCallbackProgressTimes(200);
    }

    /**
     * Download single task
     *
     * @param data     data contains some needed information likes link, path, id, status
     * @param callback get some useful information for updating view, etc.
     */
    @Override
    public void downloadSingleFile(F data, CallbackSingleDownload<F> callback) {
        BaseDownloadTask task = createNewTask(data);
        task.setListener(createSingleListener(data, callback));
        task.start();
    }

    /**
     * Download multi task
     *
     * @param listData list data contains some needed information likes link, path, id, status
     * @param callback get some useful information for updating view, etc.
     */
    @Override
    public void downloadMultiFile(List<F> listData, CallbackMultiDownload<F> callback) {
        if(listData == null || listData.isEmpty())
            callback.notifyError("Null data!");

        FileDownloadQueueSet queueSet = new FileDownloadQueueSet(createMultiListener(listData, callback));
        queueSet.setAutoRetryTimes(1);
        queueSet.disableCallbackProgressTimes();

        List<BaseDownloadTask> listTask = new ArrayList<>();
        for (F data : listData) {
            BaseDownloadTask task = createNewTask(data);
            listTask.add(task);
        }
        queueSet.downloadSequentially(listTask);
        queueSet.start();
    }

    /**
     * Create listener event for invoking data after download single file
     * <br> Data must update by following methods of CallbackSingleDownload instance
     *
     * @param data data will need when update 'status' property into sugar database
     * @param callback callback which you want to get data to update
     */
    @Override
    public FileDownloadListener createSingleListener(F data, CallbackSingleDownload<F> callback) {
        return new FileDownloadListener() {
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                data.setStatusDownload("pending");
                data.update();
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                data.setStatusDownload("progress");
                data.update();
                callback.processDownload(soFarBytes, totalBytes);
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                data.setStatusDownload("completed");
                data.update();
                callback.downloadSuccess(data);
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                data.setStatusDownload("paused");
                data.update();
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                data.setStatusDownload("error");
                data.update();

                callback.notifyError("Error " + e.getMessage());
                callback.downloadFailure();
            }

            @Override
            protected void warn(BaseDownloadTask task) {

            }
        };
    }

    /**
     * Create listener event for invoking data after download multi file
     * <br> Data must update by following methods of CallbackSingleDownload instance
     *
     * @param listData list of data, will need when update 'status' property into sugar database
     * @param callback callback which you want to get data to update
     */
    @Override
    public FileDownloadListener createMultiListener(List<F> listData, CallbackMultiDownload<F> callback) {
        final int[] order = {0};
        int size = listData.size();

        return new FileDownloadListener() {
            F curTask = listData.get(order[0]);

            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                curTask.setStatusDownload("pending");
                curTask.update();
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                curTask.setStatusDownload("progress");
                curTask.update();
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                curTask.setStatusDownload("completed");
                curTask.update();

                order[0]++;
                if (order[0] < size) {
                    // update new current task
                    curTask = listData.get(order[0]);

                    callback.downloadSuccessPart(order[0], listData);
                } else if (order[0] == size) {
                    callback.downloadSuccessAll(listData);
                }
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                curTask.setStatusDownload("paused");
                curTask.update();
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                curTask.setStatusDownload("error");
                curTask.update();

                callback.notifyError("Error " + e.getMessage());
                callback.downloadFailure();
            }

            @Override
            protected void warn(BaseDownloadTask task) {

            }
        };
    }
}
