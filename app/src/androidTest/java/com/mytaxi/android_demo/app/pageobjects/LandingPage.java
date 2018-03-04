package com.mytaxi.android_demo.app.pageobjects;

import android.os.SystemClock;
import android.support.test.espresso.matcher.ViewMatchers;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.app.views.MultiAutoSelectView;
import com.mytaxi.android_demo.app.views.MyTaxiView;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.app.utils.ActivityUtils.getCurrentActivity;
import static java.util.Calendar.SECOND;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class LandingPage extends AbstractPage {
    MyTaxiView searchTextView = new MyTaxiView(withId(R.id.textSearch));
    MultiAutoSelectView searchAutoSuggestionView = new MultiAutoSelectView(withId(R.id.textSearch));


    public LandingPage() {
        waitUntilDisplayed(searchTextView);
    }

    public LandingPage enterTextSearch(String searchText) {
        SystemClock.sleep(2000);
        searchTextView.performActions(typeText(searchText));

        return this;
    }

    public DriverInfoPage clickAutoSuggestedDriver(String value) {
        searchAutoSuggestionView.selectAutoComplete(value);

        return new DriverInfoPage();
    }
}
