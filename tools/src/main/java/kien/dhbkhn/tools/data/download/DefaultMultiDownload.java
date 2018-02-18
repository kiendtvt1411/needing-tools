package kien.dhbkhn.tools.data.download;

import java.util.List;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public class DefaultMultiDownload {

    private int idMultiDownload;

    private int idCurDownload; // task downloading in list task

    private String statusDownload;

    private List<DefaultDownload> listDownload;

    public DefaultMultiDownload() {
    }

    public int getIdMultiDownload() {
        return idMultiDownload;
    }

    public void setIdMultiDownload(int idMultiDownload) {
        this.idMultiDownload = idMultiDownload;
    }

    public int getIdCurDownload() {
        return idCurDownload;
    }

    public void setIdCurDownload(int idCurDownload) {
        this.idCurDownload = idCurDownload;
    }

    public String getStatusDownload() {
        return statusDownload;
    }

    public void setStatusDownload(String statusDownload) {
        this.statusDownload = statusDownload;
    }

    public List<DefaultDownload> getListDownload() {
        return listDownload;
    }

    public void setListDownload(List<DefaultDownload> listDownload) {
        this.listDownload = listDownload;
    }
}
