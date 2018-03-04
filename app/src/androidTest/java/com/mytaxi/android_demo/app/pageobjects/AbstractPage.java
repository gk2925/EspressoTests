package com.mytaxi.android_demo.app.pageobjects;

import android.support.annotation.NonNull;
import android.view.View;

import com.mytaxi.android_demo.app.preconditions.TestCondition;
import com.mytaxi.android_demo.app.preconditions.waitviewconditions.WaitViewDisappearCondition;
import com.mytaxi.android_demo.app.preconditions.waitviewconditions.WaitViewShownCondition;
import com.mytaxi.android_demo.app.views.AbstractView;
import com.mytaxi.android_demo.app.views.MyTaxiView;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;

public class AbstractPage {

    protected static void waitUntilDisplayed(@NonNull final Matcher<View> viewMatcher) {
        waitUntilDisplayed(new MyTaxiView(viewMatcher));
    }

    protected static void waitUntilDisplayed(final AbstractView view) {
        TestCondition waitUntilDisplayedCondition = new WaitViewShownCondition(view.getViewMatcher());
        try {
            waitUntilDisplayedCondition.setUp();
            view.isDisplayed();
        } finally {
            waitUntilDisplayedCondition.tearDown();
            closeSoftKeyboard();
        }
    }

    protected static void waitUntilDisappear(@NonNull final Matcher<View> viewMatcher) {
        waitUntilDisappear(new MyTaxiView(viewMatcher));
    }

    protected static void waitUntilDisappear(final AbstractView view) {
        TestCondition waitViewDisappearCondition = new WaitViewDisappearCondition(view.getViewMatcher());
        try {
            waitViewDisappearCondition.setUp();
            view.isNotDisplayed();
        } finally {
            waitViewDisappearCondition.tearDown();
            closeSoftKeyboard();
        }
    }

}
