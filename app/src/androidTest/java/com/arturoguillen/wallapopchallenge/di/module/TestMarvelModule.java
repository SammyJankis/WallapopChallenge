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
    MarvelApi provideFakeMarvelApi(ComicDataWrapper fakeComicDataWrapper) {
        MarvelApi mockMarvelApi = Mockito.mock(MarvelApi.class);

        Mockito.when(
                mockMarvelApi.getComicsByCharacter(
                        Mockito.anyInt(),
                        Mockito.anyString(),
                        Mockito.anyString(),
                        Mockito.anyString(),
                        Mockito.anyString()
                )
        ).thenReturn(Observable.just(fakeComicDataWrapper));
        return mockMarvelApi;
    }

    @Provides
    ComicDataWrapper provideFakeComicDataWrapper(ComicDataContainer fakeComicDataContainer) {
        ComicDataWrapper fakeComicDataWrapper = new ComicDataWrapper();
        fakeComicDataWrapper.setData(fakeComicDataContainer);

        return fakeComicDataWrapper;
    }

    @Provides
    ComicDataContainer provideFakeComicDataContainer(ArrayList<Comic> fakeComics) {
        ComicDataContainer fakeComicDataContainer = new ComicDataContainer();
        fakeComicDataContainer.setResults(fakeComics);

        return fakeComicDataContainer;
    }

    @Provides
    ArrayList<Comic> provideFakeComics(Comic fakeComic) {
        ArrayList<Comic> fakeComics = new ArrayList<>();
        fakeComics.add(fakeComic);
        fakeComics.add(fakeComic);

        return fakeComics;
    }

    @Provides
    Comic provideFakeComic(ArrayList<Image> fakeImages) {
        Comic fakeComic = new Comic();
        fakeComic.setId(1);
        fakeComic.setDescription("Description");
        fakeComic.setDigitalId(1);
        fakeComic.setIssueNumber(1.0);
        fakeComic.setTitle("Title");
        fakeComic.setVariantDescription("VariantDescription");
        fakeComic.setThumbnail(fakeImages.get(0));
        fakeComic.setImages(fakeImages);

        return fakeComic;
    }

    @Provides
    ArrayList<Image> provideFakeImages(Image fakeImage) {
        ArrayList<Image> fakeImages = new ArrayList<>();
        fakeImages.add(fakeImage);
        fakeImages.add(fakeImage);

        return fakeImages;
    }

    @Provides
    Image provideFakeImage() {
        Image fakeImage = new Image();
        fakeImage.setExtension("Extension");
        fakeImage.setPath("Path");

        return fakeImage;
    }

}
