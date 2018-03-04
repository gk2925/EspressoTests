package com.mytaxi.android_demo.app.views;

import android.support.test.espresso.action.ViewActions;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;

public class MyTaxiView extends AbstractView {

    public MyTaxiView(Matcher<View> viewMatcher) {
        super(viewMatcher);
    }

    public void click() {
        onView(viewMatcher).perform(ViewActions.click());
    }

    /**
     * Click on the view if it's displayed
     */

    public void clickIfVisible() {
        if (isViewDisplayed()) {
            onView(viewMatcher).perform(ViewActions.click());
        }
    }

    /**
     * Wait 500 ms and click on the view
     */

    public void waitAndClick() {
        //SystemClock.sleep(HALF_SECOND);
        onView(viewMatcher).perform(ViewActions.click());
    }
}
