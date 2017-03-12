package com.arturoguillen.wallapopchallenge.di.component;

import com.arturoguillen.wallapopchallenge.di.module.ImageRequestModule;
import com.arturoguillen.wallapopchallenge.di.module.MarvelModule;
import com.arturoguillen.wallapopchallenge.view.detail.DetailActivity;
import com.arturoguillen.wallapopchallenge.view.feed.FeedActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by artu on 3/8/17.
 */

@Singleton
@Component(modules = {MarvelModule.class, ImageRequestModule.class})
public interface FeedComponent {
    void inject(FeedActivity feedActivity);

    void inject(DetailActivity detailActivity);
}
