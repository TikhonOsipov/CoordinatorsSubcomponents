package com.tixon.coordinators;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public class DaggerActivityTestRule<T extends Activity> extends ActivityTestRule<T> {

    private final ActivityLaunchedListener<T> mListener;

    public DaggerActivityTestRule(Class<T> activityClass,
                                  @NonNull ActivityLaunchedListener<T> listener) {
        this(activityClass, false, listener);
    }

    public DaggerActivityTestRule(Class<T> activityClass, boolean initialTouchMode,
                                  @NonNull ActivityLaunchedListener<T> listener) {
        this(activityClass, initialTouchMode, true, listener);
    }

    public DaggerActivityTestRule(Class<T> activityClass, boolean initialTouchMode,
                                  boolean launchActivity,
                                  @NonNull ActivityLaunchedListener<T> listener) {
        super(activityClass, initialTouchMode, launchActivity);
        mListener = listener;
    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        mListener.beforeActivityLaunched((Application) InstrumentationRegistry.getInstrumentation()
                .getTargetContext().getApplicationContext(), getActivity());
    }

    public interface ActivityLaunchedListener<T> {

        void beforeActivityLaunched(@NonNull Application application, @NonNull T activity);
    }
}
