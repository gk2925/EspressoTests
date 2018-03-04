package com.mytaxi.android_demo.app.espresso.login;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.app.pageobjects.LoginPage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.mytaxi.android_demo.app.utils.Properties.TEST_PASSWORD;
import static com.mytaxi.android_demo.app.utils.Properties.TEST_USERNAME;
import static com.mytaxi.android_demo.app.utils.PropertiesUtils.getProperty;


@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule(MainActivity.class, true);

    @Test
    public void loginWithValidCredentials() {
        new LoginPage()
                .performLogin(getProperty(TEST_USERNAME), getProperty(TEST_PASSWORD));

    }

}
