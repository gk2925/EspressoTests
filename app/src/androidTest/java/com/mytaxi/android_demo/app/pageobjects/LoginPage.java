package com.mytaxi.android_demo.app.pageobjects;


import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.app.views.MyTaxiView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class LoginPage extends AbstractPage {

    MyTaxiView loginButtonView = new MyTaxiView(withId(R.id.btn_login));
    MyTaxiView userNameTextBoxView = new MyTaxiView(withId(R.id.edt_username));
    MyTaxiView passwordTextBoxView = new MyTaxiView(withId(R.id.edt_password));

    public LoginPage() {
        waitUntilDisplayed(loginButtonView);
    }

    public LandingPage performLogin(String userName, String password) {
        userNameTextBoxView.performActions(typeText(userName));
        passwordTextBoxView.performActions(typeText(password));
        loginButtonView.performActions(click());

        return new LandingPage();

    }
}
