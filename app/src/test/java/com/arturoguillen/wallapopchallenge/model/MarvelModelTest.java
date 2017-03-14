package com.arturoguillen.wallapopchallenge.model;

import com.arturoguillen.wallapopchallenge.BuildConfig;
import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.fabric.MockMarvelApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by arturo.guillen on 14/03/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MarvelModelTest {

    MarvelModel marvelModel;
    MarvelApi marvelApiMock;

    @Before
    public void setUp() throws Exception {
        marvelApiMock = MockMarvelApi.getMarvelApiMock();
        marvelModel = new MarvelModel(marvelApiMock);
    }

    @Test
    public void test_getComicsByCharacter_isCalled() throws Exception {
        MarvelModel.ResponseObserver responseObserver = new MarvelModel.ResponseObserver() {
            @Override
            public void onCompleted(ArrayList<Comic> comics) {

            }

            @Override
            public void onError(Throwable e) {

            }
        };

        marvelModel.getComicsForCharacter(23, 23, responseObserver);

        verify(marvelApiMock).getComicsByCharacter(anyInt(), anyString(), anyString(), anyString(), anyString());
    }
}
