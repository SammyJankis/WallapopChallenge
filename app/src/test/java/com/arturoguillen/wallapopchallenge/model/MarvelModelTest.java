package com.arturoguillen.wallapopchallenge.model;

import com.arturoguillen.wallapopchallenge.BuildConfig;
import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.fabric.MockMarvelApi;
import com.arturoguillen.wallapopchallenge.fabric.MockMarvelModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import io.reactivex.Observable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by arturo.guillen on 14/03/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MarvelModelTest {

    MarvelModel marvelModel;

    @Before
    public void setUp() throws Exception {
        marvelModel = new MarvelModel(MockMarvelApi.getMarvelApiMock());
    }
}
