package com.arturoguillen.wallapopchallenge.presenter;

import android.os.Bundle;

import com.arturoguillen.wallapopchallenge.view.FeedView;

import javax.inject.Inject;

/**
 * Created by artu on 3/8/17.
 */

public class FeedPresenter implements Presenter<FeedView> {

    private FeedView view;

    @Inject
    public FeedPresenter() {
    }

    @Override
    public void attachView(FeedView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
