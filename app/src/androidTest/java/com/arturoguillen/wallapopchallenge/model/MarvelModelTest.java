package com.arturoguillen.wallapopchallenge.model;

import android.support.test.runner.AndroidJUnit4;

import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.fabric.MockMarvelApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by arturo.guillen on 14/03/2017.
 */

@RunWith(AndroidJUnit4.class)
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
