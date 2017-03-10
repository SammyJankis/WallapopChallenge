package com.arturoguillen.wallapopchallenge.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arturoguillen.wallapopchallenge.Constants;
import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by artu on 3/9/17.
 */

public class ComicCard extends RecyclerView.ViewHolder {


    private static final String ASPECT_RATIO = "/portrait_incredible.";

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.progress)
    ProgressBar progress;

    private Picasso picasso;

    public ComicCard(View itemView, Picasso picasso) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.picasso = picasso;
    }

    void fillComicCard(final Comic comic) {
        title.setText(comic.getTitle());
        imageView.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                picasso.load(comic.getThumbnail().getPath() + ASPECT_RATIO + comic.getThumbnail().getExtension())
                        .resize(progress.getWidth(), progress.getHeight())
                        .noFade()
                        .error(R.drawable.noimage)
                        .tag(Constants.FEED_TAG)
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                imageView.setVisibility(View.VISIBLE);
                                progress.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError() {
                                imageView.setVisibility(View.VISIBLE);
                                progress.setVisibility(View.GONE);
                            }
                        });
            }
        });

    }

}
