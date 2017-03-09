package com.arturoguillen.wallapopchallenge.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.arturoguillen.wallapopchallenge.Constants;
import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.di.component.FeedComponent;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.presenter.FeedPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by artu on 3/8/17.
 */

public class FeedActivity extends BaseActivity implements FeedView {

    private static final String RECYCLERVIEW_STATE = "RECYCLERVIEW_STATE";
    private static final String RECYCLEVIEW_CONTENT = "RECYCLEVIEW_CONTENT";

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

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        FeedAdapter feedAdapter = new FeedAdapter();
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onRetrieveData() {
                retrieveMoreData();
            }
        });
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveMoreData();
    }

    private void retrieveMoreData() {
        int offset = recyclerView.getAdapter().getItemCount();
        presenter.getComicsForCharacter(Constants.CAPTAIN_AMERICA_ID, offset);
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
            FeedAdapter adapter = (FeedAdapter) recyclerView.getAdapter();
            adapter.appendFeedContent((ArrayList<Comic>) savedInstanceState.getSerializable(RECYCLEVIEW_CONTENT));
            recyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(RECYCLERVIEW_STATE));
            presenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FeedAdapter adapter = (FeedAdapter) recyclerView.getAdapter();
        outState.putParcelable(RECYCLERVIEW_STATE, recyclerView.getLayoutManager().onSaveInstanceState());
        outState.putSerializable(RECYCLEVIEW_CONTENT, adapter.getFeedContent());
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void showProgressFooter() {

    }

    @Override
    public void hideProgressFooter() {

    }

    @Override
    public void showMessage(@StringRes int stringId) {

    }


    @Override
    public void showMoreData(ArrayList<Comic> comics) {
        FeedAdapter adapter = (FeedAdapter) recyclerView.getAdapter();
        adapter.appendFeedContent(comics);
    }
}
