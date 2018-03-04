package com.mytaxi.android_demo.app.preconditions.waitviewconditions;

import android.view.View;

import com.mytaxi.android_demo.app.preconditions.idlingresource.WaitViewIdlingResource;

import org.hamcrest.Matcher;

public class WaitViewDisappearCondition extends WaitViewCondition {
    public WaitViewDisappearCondition(final Matcher<View> viewMatcher) {
        super(viewMatcher);
    }

    @Override
    WaitViewIdlingResource.ViewVerifier getViewVerifier() {
        return new WaitViewIdlingResource.ViewVerifier() {
            @Override
            public boolean verify(View view) {
                return view == null || !view.isShown();
            }
        };
    }
}
