package com.arturoguillen.wallapopchallenge.presenter;

import android.os.Bundle;

/**
 * Created by artu on 3/8/17.
 */

interface BasePresenterInterface {

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);
}
