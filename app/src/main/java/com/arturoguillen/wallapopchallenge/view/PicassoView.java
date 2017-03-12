package com.arturoguillen.wallapopchallenge.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.arturoguillen.wallapopchallenge.Constants;
import com.arturoguillen.wallapopchallenge.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by artu on 3/12/17.
 */

public class PicassoView extends LinearLayout {

    @BindView(R.id.picasso_image)
    ImageView picassoImage;

    @BindView(R.id.picasso_progress)
    ProgressBar picassoProgress;

    public PicassoView(Context context) {
        super(context);
        initialize();
    }

    public PicassoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public PicassoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        View view = inflate(getContext(), R.layout.picasso_view, this);
        ButterKnife.bind(this, view);
    }

    public void init(final Picasso picasso, final String path) {
        picassoImage.setVisibility(View.GONE);
        picassoProgress.setVisibility(View.VISIBLE);
        picassoProgress.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                picassoProgress.getViewTreeObserver().removeOnPreDrawListener(this);
                picasso.load(path)
                        .resize(picassoProgress.getWidth(), picassoProgress.getHeight())
                        .noFade()
                        .error(R.drawable.noimage)
                        .tag(Constants.FEED_TAG)
                        .into(picassoImage, new Callback() {
                            @Override
                            public void onSuccess() {
                                picassoImage.setVisibility(View.VISIBLE);
                                picassoProgress.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError() {
                                picassoImage.setVisibility(View.VISIBLE);
                                picassoProgress.setVisibility(View.GONE);
                            }
                        });
                return true;
            }
        });
    }
}
