package com.arturoguillen.wallapopchallenge.fabric;

import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.entity.ComicDataContainer;
import com.arturoguillen.wallapopchallenge.entity.ComicDataWrapper;
import com.arturoguillen.wallapopchallenge.entity.Image;

import java.util.ArrayList;

/**
 * Created by arturo.guillen on 14/03/2017.
 */

public class Mocks {

    public static ComicDataWrapper getFakeComicDataWrapper() {
        ComicDataWrapper fakeComicDataWrapper = new ComicDataWrapper();
        fakeComicDataWrapper.setData(getFakeComicDataContainer());
        return fakeComicDataWrapper;
    }

    public static ComicDataContainer getFakeComicDataContainer() {
        ComicDataContainer fakeComicDataContainer = new ComicDataContainer();

        ArrayList<Comic> fakeComics = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fakeComics.add(getFakeComic(i));
        }

        fakeComicDataContainer.setResults(fakeComics);
        return fakeComicDataContainer;
    }

    public static Comic getFakeComic(int counter) {
        Comic fakeComic = new Comic();
        fakeComic.setId(counter);
        fakeComic.setDescription("Description" + counter);
        fakeComic.setDigitalId(counter);
        fakeComic.setIssueNumber((double) counter);
        fakeComic.setTitle("Title" + counter);
        fakeComic.setVariantDescription("VariantDescription" + counter);

        ArrayList<Image> fakeImages = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fakeImages.add(getFakeImage());
        }

        fakeComic.setThumbnail(fakeImages.get(0));
        fakeComic.setImages(fakeImages);
        return fakeComic;
    }

    public static Image getFakeImage() {
        Image fakeImage = new Image();
        fakeImage.setExtension("Extension");
        fakeImage.setPath("Path");

        return fakeImage;
    }
}