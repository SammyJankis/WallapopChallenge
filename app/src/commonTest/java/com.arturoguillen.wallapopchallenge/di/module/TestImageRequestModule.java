package com.arturoguillen.wallapopchallenge.di.module;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.arturoguillen.wallapopchallenge.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.squareup.picasso.RequestHandler;

import org.mockito.Mockito;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.squareup.picasso.Picasso.LoadedFrom.MEMORY;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by artu on 3/9/17.
 */

@Module
public class TestImageRequestModule {

    private Application application;

    public TestImageRequestModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Picasso provideFakePicasso(RequestHandler fakeRequestCreator) {
        Picasso mockPicasso = new Picasso.Builder(application)
                .addRequestHandler(fakeRequestCreator).build();

        return mockPicasso;
    }

    @Provides
    RequestHandler provideFakeRequestHandler(Bitmap fakeBitmap) {

        RequestHandler requestHandler = Mockito.mock(RequestHandler.class);
        try {
            RequestHandler.Result result = new RequestHandler.Result(fakeBitmap, MEMORY);
            when(requestHandler.load(any(Request.class), anyInt())).thenReturn(result);
            when(requestHandler.canHandleRequest(any(Request.class))).thenReturn(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return requestHandler;
    }

    @Provides
    Bitmap provideFakeBitmap() {
        Bitmap image = BitmapFactory.decodeResource(application.getResources(),
                R.drawable.noimage);
        return image;
    }


}
