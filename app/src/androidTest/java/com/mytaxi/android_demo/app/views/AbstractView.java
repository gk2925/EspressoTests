package com.mytaxi.android_demo.app.views;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

public abstract class AbstractView {
    final Matcher<View> viewMatcher;

    public AbstractView(Matcher<View> viewMatcher) {
        this.viewMatcher = viewMatcher;
    }

    public void isNotDisplayed() {
        onView(viewMatcher).check(doesNotExist());
    }

    public void isDisplayed() {
        onView(viewMatcher).check(matches(ViewMatchers.isDisplayed()));
    }

    public Matcher<View> getViewMatcher() {
        return viewMatcher;
    }

    public boolean isViewDisplayed() {
        try {
            onView(viewMatcher).check(matches(ViewMatchers.isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            return false;
        }
    }

    public void isSelected() {
        onView(viewMatcher).check(matches(ViewMatchers.isSelected()));
    }

    public boolean isViewSelected() {
        try {
            onView(allOf(viewMatcher, ViewMatchers.isSelected())).check(matches(ViewMatchers.isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            return false;
        }
    }


    public void isEnabled() {
        onView(viewMatcher).check(matches(ViewMatchers.isEnabled()));
    }

    public void isDisabled() {
        onView(viewMatcher).check(matches(not(ViewMatchers.isEnabled())));
    }

    public void performActions(ViewAction... viewActions) {
        onView(viewMatcher).perform(viewActions);
    }
}
