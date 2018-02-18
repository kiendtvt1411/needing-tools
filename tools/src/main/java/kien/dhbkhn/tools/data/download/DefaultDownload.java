package kien.dhbkhn.tools.data.download;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public class DefaultDownload extends SugarRecord {

    @Unique
    private int idDownload;

    private String linkDownload;

    private String pathDownload;

    private String statusDownload;

    public DefaultDownload() {
    }

    public int getIdDownload() {
        return idDownload;
    }

    public void setIdDownload(int idDownload) {
        this.idDownload = idDownload;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    public String getPathDownload() {
        return pathDownload;
    }

    public void setPathDownload(String pathDownload) {
        this.pathDownload = pathDownload;
    }

    public String getStatusDownload() {
        return statusDownload;
    }

    public void setStatusDownload(String statusDownload) {
        this.statusDownload = statusDownload;
    }
}
