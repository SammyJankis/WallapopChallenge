package com.arturoguillen.wallapopchallenge;

import android.app.Application;

import com.arturoguillen.wallapopchallenge.di.component.DaggerFeedComponent;
import com.arturoguillen.wallapopchallenge.di.component.FeedComponent;

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
                .build();
    }

    public FeedComponent getComponent() {
        return component;
    }

}
