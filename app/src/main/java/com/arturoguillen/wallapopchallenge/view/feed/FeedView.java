package com.arturoguillen.wallapopchallenge.view.feed;

import android.support.annotation.StringRes;

import com.arturoguillen.wallapopchallenge.entity.Comic;

import java.util.ArrayList;

/**
 * Created by artu on 3/8/17.
 */

public interface FeedView {

    void showProgressFooter();

    void hideProgressFooter();

    void showMessage(@StringRes int stringId);

    void hideMessage();

    void showMoreData(ArrayList<Comic> comics);
}
