package com.arturoguillen.wallapopchallenge.di.module;

import com.arturoguillen.wallapopchallenge.di.api.MarvelApi;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.entity.ComicDataContainer;
import com.arturoguillen.wallapopchallenge.entity.ComicDataWrapper;
import com.arturoguillen.wallapopchallenge.entity.Image;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
    ComicDataContainer provideFakeComicDataContainer(List<Comic> fakeComics) {
        ComicDataContainer fakeComicDataContainer = new ComicDataContainer();
        fakeComicDataContainer.setResults(fakeComics);

        return fakeComicDataContainer;
    }

    @Provides
    List<Comic> provideFakeComics(Comic fakeComic0,
                                  Comic fakeComic1,
                                  Comic fakeComic2,
                                  Comic fakeComic3,
                                  Comic fakeComic4,
                                  Comic fakeComic5,
                                  Comic fakeComic6,
                                  Comic fakeComic7,
                                  Comic fakeComic8,
                                  Comic fakeComic9,
                                  Comic fakeComic10,
                                  Comic fakeComic11,
                                  Comic fakeComic12,
                                  Comic fakeComic13,
                                  Comic fakeComic14,
                                  Comic fakeComic15,
                                  Comic fakeComic16,
                                  Comic fakeComic17,
                                  Comic fakeComic18,
                                  Comic fakeComic19) {

        List<Comic> fakeComics = new ArrayList<>();
        fakeComics.add(fakeComic0);
        fakeComics.add(fakeComic1);
        fakeComics.add(fakeComic2);
        fakeComics.add(fakeComic3);
        fakeComics.add(fakeComic4);
        fakeComics.add(fakeComic5);
        fakeComics.add(fakeComic6);
        fakeComics.add(fakeComic7);
        fakeComics.add(fakeComic8);
        fakeComics.add(fakeComic9);
        fakeComics.add(fakeComic10);
        fakeComics.add(fakeComic11);
        fakeComics.add(fakeComic12);
        fakeComics.add(fakeComic13);
        fakeComics.add(fakeComic14);
        fakeComics.add(fakeComic15);
        fakeComics.add(fakeComic16);
        fakeComics.add(fakeComic17);
        fakeComics.add(fakeComic18);
        fakeComics.add(fakeComic19);

        return fakeComics;
    }

    int counter = 0;

    @Provides
    Comic provideFakeComic(List<Image> fakeImages) {
        Comic fakeComic = new Comic();
        fakeComic.setId(counter);
        fakeComic.setDescription("Description" + counter);
        fakeComic.setDigitalId(counter);
        fakeComic.setIssueNumber((double) counter);
        fakeComic.setTitle("Title" + counter);
        fakeComic.setVariantDescription("VariantDescription" + counter);
        fakeComic.setThumbnail(fakeImages.get(0));
        fakeComic.setImages(fakeImages);
        counter++;
        return fakeComic;
    }

    @Provides
    List<Image> provideFakeImages(Image fakeImage) {
        List<Image> fakeImages = new ArrayList<>();
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
