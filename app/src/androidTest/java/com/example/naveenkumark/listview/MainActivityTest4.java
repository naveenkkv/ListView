package com.example.naveenkumark.listview;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest4 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest4() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("item"),
                        withParent(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main)))),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("item"),
                        withParent(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main)))),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(android.R.id.text1), withText("item"),
                        withParent(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main)))),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(android.R.id.text1), withText("item clicked"),
                        withParent(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main)))),
                        isDisplayed()));
        appCompatTextView4.perform(click());

    }
}
