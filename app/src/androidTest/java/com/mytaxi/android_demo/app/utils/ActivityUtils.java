package com.mytaxi.android_demo.app.utils;

import android.app.Activity;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

public class ActivityUtils {

    public static Activity getCurrentActivity() {
        return getCurrentActivity(Stage.RESUMED);
    }

    public static Activity getCurrentActivity(final Stage stage) {
        class CurrentActivity {

            private Activity instance;
        }
        final CurrentActivity currentActivity = new CurrentActivity();

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Collection<Activity> activities = ActivityLifecycleMonitorRegistry.getInstance()
                        .getActivitiesInStage(stage);

                if (activities != null && activities.size() > 0) {
                    currentActivity.instance = activities.iterator().next();
                }
            }
        });

        return currentActivity.instance;
    }

}
