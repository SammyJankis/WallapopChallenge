package com.arturoguillen.wallapopchallenge.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.arturoguillen.wallapopchallenge.Constants;
import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.di.component.FeedComponent;
import com.arturoguillen.wallapopchallenge.presenter.FeedPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by artu on 3/8/17.
 */

public class FeedActivity extends BaseActivity implements FeedView {

    @Inject
    FeedPresenter presenter;

    @BindView(R.id.recyclerview_feed)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.attachView(this);
        setContentView(R.layout.activity_feed);

        ButterKnife.bind(this);

        presenter.getComicsForCharacter(Constants.CAPTAIN_AMERICA_ID);
    }

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            presenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void showProgressFooter() {

    }

    @Override
    public void hideProgressFooter() {

    }
}
