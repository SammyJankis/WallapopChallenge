package com.arturoguillen.wallapopchallenge.view.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.entity.Comic;

import butterknife.ButterKnife;

/**
 * Created by artu on 3/11/17.
 */

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_COMIC = "EXTRA_COMIC";

    public static Intent createIntent(Context context, Comic comic) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_COMIC, comic);
        return intent;
    }

    private Comic comic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

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

    }
}
