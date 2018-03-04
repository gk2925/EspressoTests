package com.mytaxi.android_demo.app.preconditions.waitviewconditions;

import android.support.test.espresso.Espresso;
import android.view.View;

import com.mytaxi.android_demo.app.preconditions.TestCondition;
import com.mytaxi.android_demo.app.preconditions.idlingresource.WaitViewIdlingResource;

import org.hamcrest.Matcher;

public abstract class WaitViewCondition implements TestCondition {

    protected Matcher<View> viewMatcher;
    private WaitViewIdlingResource idlingResource;

    WaitViewCondition(final Matcher<View> viewMatcher) {
        this.viewMatcher = viewMatcher;
    }

    @Override
    public void setUp() {
        idlingResource = new WaitViewIdlingResource(viewMatcher, getViewVerifier());
        Espresso.registerIdlingResources(idlingResource);


    }

    @Override
    public void tearDown() {
      Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = null;
    }

    abstract WaitViewIdlingResource.ViewVerifier getViewVerifier();
}
