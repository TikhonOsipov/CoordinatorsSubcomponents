package ru.tixon.coordinators.dagger.components;

import dagger.Subcomponent;
import ru.tixon.coordinators.dagger.modules.CoordinatorModule;
import ru.tixon.coordinators.dagger.modules.ScreensModule;
import ru.tixon.coordinators.dagger.scopes.ActivityScope;
import ru.tixon.coordinators.screens.login_screen.LoginActivity;
import ru.tixon.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@ActivityScope
@Subcomponent(modules = {ScreensModule.class})
public interface IScreensComponent {
    ICoordinatorComponent plus(CoordinatorModule module);
    void inject(MainActivity activity);
    void inject(LoginActivity activity);
}
