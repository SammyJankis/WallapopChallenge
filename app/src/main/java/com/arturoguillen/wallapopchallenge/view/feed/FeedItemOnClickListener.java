package com.arturoguillen.wallapopchallenge.view.feed;

import android.view.View;

import com.arturoguillen.wallapopchallenge.entity.Comic;

/**
 * Created by artu on 3/11/17.
 */

public interface FeedItemOnClickListener {

    void onClickFeedItem(View v, Comic comic);
}
