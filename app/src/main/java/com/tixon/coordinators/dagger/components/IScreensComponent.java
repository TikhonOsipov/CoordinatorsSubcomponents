package com.tixon.coordinators.dagger.components;

import dagger.Subcomponent;
import com.tixon.coordinators.dagger.modules.ScreensModule;
import com.tixon.coordinators.dagger.scopes.ActivityScope;
import com.tixon.coordinators.screens.login_screen.LoginActivity;
import com.tixon.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@ActivityScope
@Subcomponent(modules = {ScreensModule.class})
public interface IScreensComponent {
    void inject(MainActivity activity);
    void inject(LoginActivity activity);
}
