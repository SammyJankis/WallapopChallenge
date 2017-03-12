package com.arturoguillen.wallapopchallenge.view;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.view.feed.FeedActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by artu on 3/8/17.
 */

@RunWith(AndroidJUnit4.class)
public class FeedActivityTest {

    @Rule
    public ActivityTestRule<FeedActivity> activityRule = new ActivityTestRule<>(
            FeedActivity.class,
            true,
            false);


    @Test
    public void testRecyclerViewIsDisplayed() {
        FeedActivity feedActivity = activityRule.launchActivity(new Intent());

        onView(withId(R.id.recyclerview_feed)).check(matches(isDisplayed()));
    }
}
