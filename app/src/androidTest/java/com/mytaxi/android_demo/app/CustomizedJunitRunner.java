package com.mytaxi.android_demo.app;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.core.deps.guava.base.Optional;
import android.support.test.runner.AndroidJUnitRunner;

import com.mytaxi.android_demo.app.utils.PropertiesUtils;

import java.util.concurrent.TimeUnit;

import static com.mytaxi.android_demo.app.utils.PropertiesUtils.setProperty;
import static com.mytaxi.android_demo.app.utils.TestConstants.IDLING_TIMEOUT_IN_MS;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class CustomizedJunitRunner extends AndroidJUnitRunner {
    @Override
    public void onCreate(@NonNull final Bundle arguments) {
        PropertiesUtils.initPropertiesFromResources(arguments.getString("profile"));
        super.onCreate(arguments);
        //IdlingPolicies.setIdlingResourceTimeout(IDLING_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS);
        //IdlingPolicies.setMasterPolicyTimeout(IDLING_TIMEOUT_IN_MS * 3, TimeUnit.MILLISECONDS);
    }
}
