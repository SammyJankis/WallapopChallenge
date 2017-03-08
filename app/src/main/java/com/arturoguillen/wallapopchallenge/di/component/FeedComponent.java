package com.arturoguillen.wallapopchallenge.di.component;

import com.arturoguillen.wallapopchallenge.view.FeedActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by artu on 3/8/17.
 */

@Singleton
@Component(modules = {})
public interface FeedComponent {
    void inject(FeedActivity feedActivity);
}
