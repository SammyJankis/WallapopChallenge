package com.arturoguillen.wallapopchallenge.fabric;

import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by arturo.guillen on 14/03/2017.
 */

public class MockMarvelApi {

    public static MarvelApi getMarvelApiMock() {
        MarvelApi marvelApi = mock(MarvelApi.class);

        when(
                marvelApi.getComicsByCharacter(
                        anyInt(),
                        anyString(),
                        anyString(),
                        anyString(),
                        anyString()
                )
        ).thenReturn(
                Observable.just(
                        Mocks.getFakeComicDataWrapper()
                )
        );

        return marvelApi;
    }
}
