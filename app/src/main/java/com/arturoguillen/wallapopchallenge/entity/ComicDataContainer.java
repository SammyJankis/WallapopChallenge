package com.arturoguillen.wallapopchallenge.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by artu on 3/8/17.
 */

public class ComicDataContainer implements Serializable {

    private static final long serialVersionUID = 1L;


    @SerializedName("offset")
    private int offset;

    @SerializedName("limit")
    private int limit;

    @SerializedName("total")
    private int total;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<Comic> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Comic> getResults() {
        return results;
    }

    public void setResults(List<Comic> results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
