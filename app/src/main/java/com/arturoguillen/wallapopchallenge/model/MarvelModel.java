package com.arturoguillen.wallapopchallenge.model;

import com.arturoguillen.wallapopchallenge.PrivateConstants;
import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.entity.ComicDataWrapper;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by artu on 3/8/17.
 */

public class MarvelModel extends BaseModel {

    @Inject
    public MarvelApi marvelApi;

    int offset = 0;

    public
    @Inject
    MarvelModel() {

    }

    public interface ResponseObserver {

        void onCompleted(ArrayList<Comic> comics);

        void onError(Throwable e);
    }

    public Disposable getComicsForCharacter(int characterId, final ResponseObserver observer) {

        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            String hash = md5(timestamp + PrivateConstants.PRIVATE_KEY + PrivateConstants.PUBLIC_KEY);

            Observable<ComicDataWrapper> observable = marvelApi.getComicsByCharacter(characterId, PrivateConstants.PUBLIC_KEY, timestamp, hash, String.valueOf(offset));

            return observable.
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribeWith(new DisposableObserver<ComicDataWrapper>() {
                        @Override
                        public void onNext(ComicDataWrapper comicDataWrapper) {
                            offset = offset + comicDataWrapper.getData().getCount();
                            observer.onCompleted(comicDataWrapper.getData().getResults());
                        }

                        @Override
                        public void onError(Throwable e) {
                            observer.onError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (NoSuchAlgorithmException e) {
            observer.onError(e);
            e.printStackTrace();
            return null;
        }
    }
}