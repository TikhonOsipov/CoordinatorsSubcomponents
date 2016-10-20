package ru.hiq.coordinators;

import android.app.Application;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import ru.hiq.coordinators.application.App;
import ru.hiq.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public final ActivityTestRule<MainActivity> rule =
            new DaggerActivityTestRule<>(MainActivity.class, new DaggerActivityTestRule.ActivityLaunchedListener<MainActivity>() {
                @Override
                public void beforeActivityLaunched(@NonNull Application application, @NonNull MainActivity activity) {
                    ((App) application).setUseTestScreenModule(true);
                }
            });


    @Test
    public void testActivity() throws Exception {
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(30));
    }
}
