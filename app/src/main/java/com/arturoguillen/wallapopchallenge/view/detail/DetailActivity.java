package com.arturoguillen.wallapopchallenge.view.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.di.component.FeedComponent;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.view.BaseActivity;
import com.arturoguillen.wallapopchallenge.view.PicassoView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by artu on 3/11/17.
 */

public class DetailActivity extends BaseActivity {

    private static final String EXTRA_COMIC = "EXTRA_COMIC";

    private static final String ASPECT_RATIO = "/landscape_incredible.";

    @BindView(R.id.detail_title)
    TextView detailTitle;

    @BindView(R.id.detail_description)
    TextView detailDescription;

    @BindView(R.id.detail_picasso)
    PicassoView picassoView;

    @Inject
    Picasso picasso;

    private Comic comic;

    public static Intent createIntent(Context context, Comic comic) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_COMIC, comic);
        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        comic = getComicExtra(savedInstanceState);

        initUI(comic);

    }

    private void initUI(final Comic comic) {
        detailTitle.setText(comic.getTitle());
        detailDescription.setText(comic.getDescription());
        picassoView.init(picasso, comic.getThumbnail().getPath() + ASPECT_RATIO + comic.getThumbnail().getExtension());
    }

    private Comic getComicExtra(Bundle savedInstanceState) {
        Comic comic;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                comic = null;
            } else {
                comic = (Comic) extras.get(EXTRA_COMIC);
            }
        } else {
            comic = (Comic) savedInstanceState.get(EXTRA_COMIC);
        }
        return comic;
    }

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_COMIC, comic);
    }
}
