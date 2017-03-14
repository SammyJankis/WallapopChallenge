package com.arturoguillen.wallapopchallenge.model;

import com.arturoguillen.wallapopchallenge.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Created by arturo.guillen on 14/03/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class BaseModelTest {

    BaseModel baseModel;

    @Before
    public void setUp() throws Exception {
        baseModel = new BaseModel();
    }

    @Test
    public void test_MD5_returns_correct_hash() throws Exception {
        String encoding = baseModel.md5("wallapopchallenge");
        assertEquals("36bdb69e6f0acba4c7c86d26cdd0058f", encoding);
    }
}
