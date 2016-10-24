package com.tixon.coordinators.dagger.components;

import dagger.Subcomponent;
import com.tixon.coordinators.dagger.modules.ScreensTestModule;
import com.tixon.coordinators.dagger.scopes.ActivityScope;
import com.tixon.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

@ActivityScope
@Subcomponent(modules = {ScreensTestModule.class})
public interface IScreensTestComponent {
    void inject(MainActivity activity);
}
