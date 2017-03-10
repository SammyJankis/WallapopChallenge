package com.arturoguillen.wallapopchallenge;

import android.app.Application;

import com.arturoguillen.wallapopchallenge.di.component.DaggerFeedComponent;
import com.arturoguillen.wallapopchallenge.di.component.FeedComponent;
import com.arturoguillen.wallapopchallenge.di.module.ImageRequestModule;
import com.arturoguillen.wallapopchallenge.di.module.MarvelModule;

/**
 * Created by artu on 3/8/17.
 */

public class App extends Application {

    private FeedComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
    }

    protected FeedComponent createComponent() {
        return DaggerFeedComponent.builder()
                .marvelModule(new MarvelModule())
                .imageRequestModule(new ImageRequestModule(this))
                .build();
    }

    public FeedComponent getComponent() {
        return component;
    }

}
