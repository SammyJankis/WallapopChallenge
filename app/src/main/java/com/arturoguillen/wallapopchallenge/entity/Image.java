package com.arturoguillen.wallapopchallenge.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by artu on 3/8/17.
 */

public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
