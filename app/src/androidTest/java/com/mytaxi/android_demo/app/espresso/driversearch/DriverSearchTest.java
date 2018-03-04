package com.mytaxi.android_demo.app.espresso.driversearch;

import android.content.Intent;
import android.net.Uri;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.app.pageobjects.LandingPage;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.core.AllOf.allOf;

public class DriverSearchTest {

    private static final String PHONE = "01748819231";
    private static final Uri VALID_PHONE = Uri.parse("tel:" + PHONE);
    private static String PACKAGE_ANDROID_DIALER = "com.android.phone";

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);


    @Test
    public void testForDriverCall() {

        new LandingPage()
                .enterTextSearch("S")
                .enterTextSearch("a")
                .clickAutoSuggestedDriver("Sarah Friedrich")
                .callSelectedDriver();

        intended(allOf(hasAction(Intent.ACTION_DIAL),
                toPackage("com.google.android.dialer")));


    }
}
