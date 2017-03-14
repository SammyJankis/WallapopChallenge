package com.arturoguillen.wallapopchallenge.fabric;

import com.arturoguillen.wallapopchallenge.model.MarvelModel;

import io.reactivex.disposables.Disposable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by artu on 3/14/17.
 */

public class MockMarvelModel {

    public static MarvelModel getMarvelModelMock() {

        MarvelModel marvelModel = mock(MarvelModel.class);
        Disposable disposable = new Disposable() {
            @Override
            public void dispose() {

            }

            @Override
            public boolean isDisposed() {
                return false;
            }
        };
        when(
                marvelModel.getComicsForCharacter(
                        anyInt(),
                        anyInt(),
                        any(MarvelModel.ResponseObserver.class)
                )
        ).thenReturn(disposable);

        return marvelModel;
    }
}
