package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by yunfei on 2018-03-14.
 */

public class DeleteDataTest {

    @Rule
    public ActivityTestRule<DetailViewActivity> detailViewActivityActivityTestRule
            = new ActivityTestRule<DetailViewActivity>(DetailViewActivity.class);


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateInput(){


        Espresso.onView(withId(R.id.deleteButton)).perform(click());
        // show the result
        Espresso.onView(withId(R.id.check_result)).check(matches(withText("remove data successful")));



    }

    @After
    public void tearDown() throws Exception {
    }



}
