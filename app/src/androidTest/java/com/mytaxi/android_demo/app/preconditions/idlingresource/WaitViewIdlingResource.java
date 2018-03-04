package com.mytaxi.android_demo.app.preconditions.idlingresource;

import android.support.annotation.NonNull;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewFinder;
import android.support.test.espresso.ViewInteraction;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;

import java.lang.reflect.Field;

import static android.support.test.espresso.Espresso.onView;
import static com.mytaxi.android_demo.app.utils.TestConstants.ESPRESSO_TAG;

public class WaitViewIdlingResource implements IdlingResource {
    private static final String TAG = WaitViewIdlingResource.class.getSimpleName();
    private boolean internalCall;

    private VsViewFinder viewFinder;
    private ViewVerifier viewVerifier;
    private ResourceCallback resourceCallback;
    private boolean previousIdle = false;

    public WaitViewIdlingResource(@NonNull final Matcher<View> viewMatcher, @NonNull final ViewVerifier viewVerifier) {
        this.viewVerifier = viewVerifier;
        this.viewFinder = new VsViewFinder(viewMatcher);
    }

    @Override
    public boolean isIdleNow() {
        if (internalCall) {
            Log.d(TAG, "*** Recursion call ***" + viewFinder.getViewMatcher().toString());
            return true;
        }
        internalCall = true;
        View view = viewFinder.getView();
        boolean idle = viewVerifier.verify(view);

        if (idle != previousIdle && idle && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
        previousIdle = idle;
        internalCall = false;

        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(@NonNull final ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    /**
     * This is needed to make sure the idling resource is reusable
     */
    @Override
    public String getName() {
        return this + viewFinder.getViewMatcher().toString();
    }

    public interface ViewVerifier {

        boolean verify(View view);
    }

    private class VsViewFinder implements ViewFinder {

        private Matcher<View> viewMatcher;

        VsViewFinder(Matcher<View> viewMatcher) {
            this.viewMatcher = viewMatcher;
        }

        @Override
        public View getView() {
            try {
                ViewInteraction viewInteraction = onView(viewMatcher);
                Field finderField = viewInteraction.getClass().getDeclaredField("viewFinder");
                finderField.setAccessible(true);
                ViewFinder finder = (ViewFinder) finderField.get(viewInteraction);
                return finder.getView();
            } catch (NoMatchingViewException e) {
                Log.e(ESPRESSO_TAG, e.getMessage());
            } catch (NoSuchFieldException e) {
                Log.e(ESPRESSO_TAG, "ViewFinder is not present");
            } catch (IllegalAccessException | IllegalStateException e) {
                Log.e(ESPRESSO_TAG, "ViewFinder is not accessible");
            }
            return null;
        }

        public Matcher<View> getViewMatcher() {
            return viewMatcher;
        }
    }
}
