package com.example.naveenkumark.listview;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
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
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("item1"),
                        childAtPosition(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main))), 0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("item5"),
                        childAtPosition(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main))), 4),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(android.R.id.text1), withText("item3"),
                        childAtPosition(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main))), 2),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(android.R.id.text1), withText("item2"),
                        childAtPosition(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main))), 1),
                        isDisplayed()));
        appCompatTextView4.perform(click());

        ViewInteraction appCompatTextView5 = onView(
                allOf(withId(android.R.id.text1), withText("item4"),
                        childAtPosition(allOf(withId(R.id.listView),
                                withParent(withId(R.id.activity_main))), 3),
                        isDisplayed()));
        appCompatTextView5.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
