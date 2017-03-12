package com.arturoguillen.wallapopchallenge.view.feed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by artu on 3/9/17.
 */

public class FeedAdapter extends RecyclerView.Adapter {

    private ArrayList<Comic> feedContent;

    private Picasso picasso;
    private FeedItemOnClickListener feedItemOnClickListener;

    public FeedAdapter(Picasso picasso, FeedItemOnClickListener feedItemOnClickListener) {
        this.feedContent = new ArrayList<>();
        this.picasso = picasso;
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    public void appendFeedContent(ArrayList<Comic> feedContent) {
        int previousSize = this.feedContent.size();
        this.feedContent.addAll(feedContent);
        notifyItemRangeInserted(previousSize, feedContent.size());
    }

    public ArrayList<Comic> getFeedContent() {
        return feedContent;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ComicCard(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_comic, parent, false), picasso, feedItemOnClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ComicCard) holder).fillComicCard(feedContent.get(position));
    }

    @Override
    public int getItemCount() {
        return feedContent.size();
    }
}
