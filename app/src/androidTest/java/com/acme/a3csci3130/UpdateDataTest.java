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

public class UpdateDataTest {
    @Rule
    public ActivityTestRule<DetailViewActivity> detailViewActivityActivityTestRule
            = new ActivityTestRule<DetailViewActivity>(DetailViewActivity.class);

    private String busiNum = "221212121";
    private String busiName = "From the ocean";
    private String priBusi = "Fish";
    private String address = "Walnut 1343, Halifax";
    private String province = "BC";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateInput(){
        Espresso.onView(withId(R.id.dv_number)).perform(typeText(busiNum));
        Espresso.onView(withId(R.id.dv_name)).perform(typeText(busiName));
        Espresso.onView(withId(R.id.dv_primary)).perform(typeText(priBusi));
        Espresso.onView(withId(R.id.dv_address)).perform(typeText(address));
        Espresso.onView(withId(R.id.dv_province)).perform(typeText(province));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.updateButton)).perform(click());
        // show the result
        Espresso.onView(withId(R.id.check_result)).check(matches(withText("Update is not success. Check entered data")));



    }

    @After
    public void tearDown() throws Exception {
    }

}
