package com.arturoguillen.wallapopchallenge.view.feed;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    protected boolean isRetrievingData = false;
    protected int previousItemCount = 0;

    @Override
    public void onScrolled(RecyclerView mRecyclerView, int dx, int dy) {
        super.onScrolled(mRecyclerView, dx, dy);
        int lastVisibleItemIndex = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        int itemCount = mRecyclerView.getLayoutManager().getItemCount();
        onScroll(itemCount, lastVisibleItemIndex);
    }

    protected void onScroll(int itemCount, int lastVisibleItemIndex) {

        if (isItemCountIncreased(itemCount)) {
            isRetrievingData = false;
        }

        if (!isRetrievingData && isRetrievingIndexReached(itemCount, lastVisibleItemIndex) && isGreaterThanZero(itemCount)) {
            isRetrievingData = true;
            onRetrieveData();
        }
        refresh(itemCount);
    }

    private boolean isItemCountIncreased(int itemCount) {
        return itemCount > previousItemCount;
    }

    private boolean isGreaterThanZero(int itemCount) {
        return itemCount > 0;
    }

    private boolean isRetrievingIndexReached(int itemCount, int lastVisibleItemIndex) {
        int THRESHOLD = 5;
        int lastIndexToStartRetrieve = lastVisibleItemIndex + THRESHOLD;
        return itemCount <= lastIndexToStartRetrieve;
    }

    private void refresh(int itemCount) {
        previousItemCount = itemCount;
    }

    public abstract void onRetrieveData();
}