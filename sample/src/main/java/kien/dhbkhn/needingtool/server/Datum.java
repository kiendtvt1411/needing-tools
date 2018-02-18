package kien.dhbkhn.needingtool.server;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by KienDepTrai on 27/09/2017.
 */

public class Datum implements Comparable<Datum> {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("categories")
    @Expose
    private String categories;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(@NonNull Datum datum) {
        if (Integer.parseInt(this.getRank()) > Integer.parseInt(datum.getRank())) {
            return 1;
        }
        else if (Integer.parseInt(this.getRank()) < Integer.parseInt(datum.getRank())) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
