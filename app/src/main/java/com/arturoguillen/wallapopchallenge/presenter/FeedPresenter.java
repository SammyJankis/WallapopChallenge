package com.arturoguillen.wallapopchallenge.presenter;

import android.os.Bundle;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.model.MarvelModel;
import com.arturoguillen.wallapopchallenge.view.feed.FeedView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by artu on 3/8/17.
 */

public class FeedPresenter implements PresenterInterface<FeedView>, BasePresenterInterface {

    private FeedView view;

    private Disposable getComicsDisposable;

    @Inject
    public MarvelModel marvelModel;

    @Inject
    public FeedPresenter() {
    }

    public FeedPresenter(MarvelModel marvelModel) {
        this.marvelModel = marvelModel;
    }

    public void getComicsForCharacter(int characterId, int offset) {
        view.showProgressFooter();
        getComicsDisposable = marvelModel.getComicsForCharacter(characterId, offset, new MarvelModel.ResponseObserver() {
            @Override
            public void onCompleted(ArrayList<Comic> comics) {
                view.hideProgressFooter();
                view.hideMessage();
                view.showMoreData(comics);
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgressFooter();
                view.showMessage(R.string.try_again);
                e.printStackTrace();
            }
        });
    }

    @Override
    public void attachView(FeedView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if (getComicsDisposable != null)
            getComicsDisposable.dispose();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
