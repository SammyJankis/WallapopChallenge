package com.arturoguillen.wallapopchallenge;

import com.arturoguillen.wallapopchallenge.di.component.DaggerTestFeedComponent;
import com.arturoguillen.wallapopchallenge.di.component.FeedComponent;

/**
 * Created by artu on 3/8/17.
 */

public class TestApp extends App {
    @Override
    protected FeedComponent createComponent() {
        return DaggerTestFeedComponent.builder()
                .build();
    }
}
