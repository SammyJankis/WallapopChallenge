package com.arturoguillen.wallapopchallenge.di.module;

import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.entity.ComicDataContainer;
import com.arturoguillen.wallapopchallenge.entity.ComicDataWrapper;
import com.arturoguillen.wallapopchallenge.entity.Image;

import org.mockito.Mockito;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

/**
 * Created by artu on 3/8/17.
 */

@Module
public class TestMarvelModule {

    @Provides
    @Singleton
    MarvelApi provideMarvelApi(ComicDataWrapper fakeComicDataWrapper) {
        MarvelApi mockMarvelApi = Mockito.mock(MarvelApi.class);

        Mockito.when(
                mockMarvelApi.getComicsByCharacter(
                        (Integer) Mockito.any(),
                        (String) Mockito.any(),
                        (String) Mockito.any(),
                        (String) Mockito.any(),
                        (String) Mockito.any()
                )
        ).thenReturn(Observable.just(fakeComicDataWrapper));
        return mockMarvelApi;
    }

    @Provides
    ComicDataWrapper provideFakeComicDataWrapper() {
        ComicDataWrapper comicDataWrapper = new ComicDataWrapper();
        comicDataWrapper.setData(new ComicDataContainer());

        return comicDataWrapper;
    }

    @Provides
    ComicDataContainer provideFakeComicDataContainer() {
        ComicDataContainer comicDataContainer = new ComicDataContainer();
        comicDataContainer.setResults(new ArrayList<Comic>());

        return comicDataContainer;
    }

    @Provides
    ArrayList<Comic> provideFakeComicArray() {
        ArrayList<Comic> comicArrayResponse = new ArrayList<>();
        comicArrayResponse.add(new Comic());
        comicArrayResponse.add(new Comic());

        return comicArrayResponse;
    }

    @Provides
    Comic provideFakeComic() {
        Comic comic = new Comic();
        comic.setId(1);
        comic.setDescription("Description");
        comic.setDigitalId(1);
        comic.setIssueNumber(1.0);
        comic.setTitle("Title");
        comic.setVariantDescription("VariantDescription");
        comic.setThumbnail(new Image());

        ArrayList<Image> fakeImagesArray = new ArrayList<>();
        fakeImagesArray.add(new Image());
        fakeImagesArray.add(new Image());
        comic.setImages(fakeImagesArray);

        return comic;
    }

    @Provides
    Image provideFakeImage() {
        Image fakeImage = new Image();
        fakeImage.setExtension("Extension");
        fakeImage.setPath("Path");
        return fakeImage;
    }

}
