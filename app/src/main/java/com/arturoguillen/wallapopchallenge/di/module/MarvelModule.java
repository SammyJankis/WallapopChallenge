package com.arturoguillen.wallapopchallenge.di.module;

import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by artu on 3/8/17.
 */

@Module
public class MarvelModule extends NetModule {

    @Provides
    @Singleton
    MarvelApi provideMarvelApi(Retrofit retrofit) {
        return retrofit.create(MarvelApi.class);
    }
}
