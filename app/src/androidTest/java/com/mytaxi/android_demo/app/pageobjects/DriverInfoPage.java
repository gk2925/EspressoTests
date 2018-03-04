package com.mytaxi.android_demo.app.pageobjects;

import android.os.SystemClock;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.app.views.MyTaxiView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class DriverInfoPage extends AbstractPage {
    MyTaxiView fabIcon = new MyTaxiView(withId(R.id.fab));

    public DriverInfoPage() {
        waitUntilDisplayed(fabIcon);
    }

    public void callSelectedDriver() {
        onView(withId(R.id.fab)).perform(click());

    }
}
