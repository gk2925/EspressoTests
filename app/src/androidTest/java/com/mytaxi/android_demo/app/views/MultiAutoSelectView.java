package com.mytaxi.android_demo.app.views;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.app.utils.ActivityUtils.getCurrentActivity;
import static com.mytaxi.android_demo.app.utils.TestConstants.HALF_SECOND;
import static java.util.Calendar.SECOND;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class MultiAutoSelectView extends AbstractView{
    public MultiAutoSelectView(Matcher<View> matcher) {
        super(matcher);
    }

    public  void selectAutoComplete(@NonNull final String value) {
        /*
        This sleep is needed because sometimes the app doesn't react when clicking on
        suggestion directly after typing text
         */
        SystemClock.sleep(4000);

        onView(allOf(withText(value), ViewMatchers.isDisplayed()))
                .inRoot(withDecorView(not(is(getCurrentActivity().getWindow().getDecorView()))))
                .perform(click());

    }
}

