package com.arturoguillen.wallapopchallenge.di.module;

import com.squareup.picasso.Picasso;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by artu on 3/9/17.
 */

@Module
public class TestImageRequestModule {

    @Provides
    @Singleton
    Picasso providePicasso() {
        return Mockito.mock(Picasso.class);
    }
}
