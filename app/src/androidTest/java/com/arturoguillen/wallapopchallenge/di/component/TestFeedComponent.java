package com.arturoguillen.wallapopchallenge.di.component;

import com.arturoguillen.wallapopchallenge.di.module.TestMarvelModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by artu on 3/8/17.
 */

@Singleton
@Component(modules = {TestMarvelModule.class})
public interface TestFeedComponent extends FeedComponent {
}
