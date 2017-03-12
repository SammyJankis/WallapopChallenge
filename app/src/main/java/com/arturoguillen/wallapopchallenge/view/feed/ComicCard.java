package com.arturoguillen.wallapopchallenge.view.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.view.PicassoView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by artu on 3/9/17.
 */

public class ComicCard extends RecyclerView.ViewHolder {


    private static final String ASPECT_RATIO = "/portrait_incredible.";

    @BindView(R.id.layout_content)
    LinearLayout layoutContent;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.feed_picasso)
    PicassoView feedPicasso;

    private Picasso picasso;
    private FeedItemOnClickListener feedItemOnClickListener;

    public ComicCard(View itemView, Picasso picasso, FeedItemOnClickListener feedItemOnClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.picasso = picasso;
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    void fillComicCard(final Comic comic) {
        title.setText(comic.getTitle());
        feedPicasso.init(picasso, comic.getThumbnail().getPath() + ASPECT_RATIO + comic.getThumbnail().getExtension());
        layoutContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedItemOnClickListener.onClickFeedItem(itemView, comic);
            }
        });

    }

}
