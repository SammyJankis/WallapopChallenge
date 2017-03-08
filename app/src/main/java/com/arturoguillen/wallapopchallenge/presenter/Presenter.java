package com.arturoguillen.wallapopchallenge.presenter;

import android.os.Bundle;

/**
 * Created by aguillen on 3/8/17.
 */

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);

}
