package com.arturoguillen.wallapopchallenge.view;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.arturoguillen.wallapopchallenge.R;
import com.arturoguillen.wallapopchallenge.view.detail.DetailActivity;
import com.arturoguillen.wallapopchallenge.view.feed.ComicCard;
import com.arturoguillen.wallapopchallenge.view.feed.FeedActivity;
import com.arturoguillen.wallapopchallenge.view.feed.FeedAdapter;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by artu on 3/8/17.
 */

@RunWith(AndroidJUnit4.class)
public class FeedActivityTest {

    @Rule
    public ActivityTestRule<FeedActivity> activityRule = new ActivityTestRule<>(FeedActivity.class, false, false);
    @Rule
    public IntentsTestRule<FeedActivity> intentsRule = new IntentsTestRule<>(FeedActivity.class, false, false);

    @Test
    public void testRecyclerView_IsDisplayed() {
        activityRule.launchActivity(new Intent());

        onView(withId(R.id.recyclerview_feed)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerView_Position0_HasText() {
        activityRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.recyclerview_feed))
                .perform(RecyclerViewActions.scrollToHolder(isPosition(0)));

        onView(withText("Title0")).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerView_Position19_HasText() {
        activityRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.recyclerview_feed))
                .perform(RecyclerViewActions.scrollToHolder(isPosition(19)));

        onView(withText("Title19")).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerView_Position0_click_then_intentWithExtras_launched() {
        FeedActivity feedActivity = intentsRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.recyclerview_feed))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        RecyclerView recyclerView = (RecyclerView) feedActivity.findViewById(R.id.recyclerview_feed);
        intended(hasExtra("EXTRA_COMIC", ((FeedAdapter) recyclerView.getAdapter()).getFeedContent().get(0)));
    }

    @Test
    public void testRecyclerView_Position0_click_then_DetailActivity_launched() {
        intentsRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.recyclerview_feed))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        intended(hasComponent(DetailActivity.class.getName()));
    }

    private static Matcher<ComicCard> isPosition(final int position) {
        return new TypeSafeMatcher<ComicCard>() {
            @Override
            protected boolean matchesSafely(ComicCard comicCard) {
                return comicCard.getLayoutPosition() == position;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("item in position " + position);
            }
        };
    }

}
