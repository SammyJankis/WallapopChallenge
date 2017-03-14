package com.arturoguillen.wallapopchallenge.presenter;

import com.arturoguillen.wallapopchallenge.BuildConfig;
import com.arturoguillen.wallapopchallenge.fabric.MockMarvelModel;
import com.arturoguillen.wallapopchallenge.model.MarvelModel;
import com.arturoguillen.wallapopchallenge.view.feed.FeedView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by artu on 3/14/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class FeedPresenterTest {

    FeedPresenter feedPresenter;
    MarvelModel marvelModelMock;
    FeedView feedViewMock;

    @Before
    public void setUp() throws Exception {
        marvelModelMock = MockMarvelModel.getMarvelModelMock();
        feedViewMock = mock(FeedView.class);
        feedPresenter = new FeedPresenter(marvelModelMock);
        feedPresenter.attachView(feedViewMock);
    }

    @Test
    public void test_showProgressFooter_isCalled_when_getComicsForCharacter() {
        feedPresenter.getComicsForCharacter(23, 23);

        verify(feedViewMock).showProgressFooter();
    }

    @Test
    public void test_getComicsForCharacter_isCalled_when_getComicsForCharacter() {
        feedPresenter.getComicsForCharacter(23, 23);

        verify(marvelModelMock).getComicsForCharacter(anyInt(), anyInt(), any(MarvelModel.ResponseObserver.class));
    }

}
