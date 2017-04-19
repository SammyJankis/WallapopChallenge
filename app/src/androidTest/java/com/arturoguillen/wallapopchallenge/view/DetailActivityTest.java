package com.arturoguillen.wallapopchallenge.view;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.entity.Comic;
import com.arturoguillen.wallapopchallenge.entity.Image;
import com.arturoguillen.wallapopchallenge.view.detail.DetailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by artu on 3/13/17.
 */

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailActivity.class);

            Comic fakeComic = new Comic();
            fakeComic.setId(0);
            fakeComic.setDescription("Description");
            fakeComic.setDigitalId(0);
            fakeComic.setIssueNumber((double) 0);
            fakeComic.setTitle("Title");
            fakeComic.setVariantDescription("VariantDescription");

            Image fakeImage = new Image();
            fakeImage.setExtension("Extension");
            fakeImage.setPath("Path");
            fakeComic.setThumbnail(fakeImage);

            List<Image> images = new ArrayList<>();
            images.add(fakeImage);
            fakeComic.setImages(images);

            result.putExtra("EXTRA_COMIC", fakeComic);
            return result;
        }
    };


    @Test
    public void testDetailImage_IsDisplayed() {
        onView(withId(R.id.detail_picasso)).check(matches(isDisplayed()));
    }

    @Test
    public void testDetailTitle_IsDisplayed() {
        onView(withId(R.id.detail_title)).check(matches(isDisplayed()));
    }

    @Test
    public void testDetailDescription_IsDisplayed() {
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()));
    }

    @Test
    public void testDetailTitle_Is_Title() {
        onView(withId(R.id.detail_title)).check(matches(withText("Title")));
    }

    @Test
    public void testDetailDescription_Is_Description() {
        onView(withId(R.id.detail_description)).check(matches(withText("Description")));
    }
}
