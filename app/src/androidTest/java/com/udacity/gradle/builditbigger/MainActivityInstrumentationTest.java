package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by shvartsy on 3/20/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    private Activity activity;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() {
        activity = activityTestRule.launchActivity(new Intent());
    }

    @Test
    public void verifyJokeInstructionsDisplayed() {
        onView(withText(R.string.instructions))
                .check(matches(isDisplayed()));
    }

    @Test
    public void verifyAdViewDisplayed() {
        onView(withId(R.id.adView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void verifyJokeButtonReady() {
        onView(withContentDescription(R.string.button_text))
                .check(matches(isDisplayed()))
                .check(matches(isEnabled()))
                .check(matches(isClickable()));
    }

    @Test
    public void verifyClickOnJokeButtonOpensJokePage() {
        onView(withContentDescription(R.string.button_text))
                .perform(click());

        onView(withId(R.id.joke_label))
                .check(matches(isDisplayed()));
    }

    @Test
    public void verifyClickOnJokeButtonShowsJoke() {
        onView(withContentDescription(R.string.button_text))
                .perform(click());

        onView(withId(R.id.joke_text))
                .check(matches(isDisplayed()));
    }
}
