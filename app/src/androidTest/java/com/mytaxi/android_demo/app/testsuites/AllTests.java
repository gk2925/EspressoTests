package com.mytaxi.android_demo.app.testsuites;

import com.mytaxi.android_demo.app.espresso.driversearch.DriverSearchTest;
import com.mytaxi.android_demo.app.espresso.login.LoginTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        DriverSearchTest.class,
})
public class AllTests {
}
