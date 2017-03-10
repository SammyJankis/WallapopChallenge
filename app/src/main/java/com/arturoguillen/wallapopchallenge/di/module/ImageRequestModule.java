package com.arturoguillen.wallapopchallenge.di.module;

import android.app.Application;
import android.net.Uri;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by artu on 3/9/17.
 */

@Module
public class ImageRequestModule {

    private Application application;

    public ImageRequestModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Picasso providePicasso() {
        return new Picasso.Builder(application)
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        exception.printStackTrace();
                    }
                })
                .build();
    }
}
