package ru.hiq.coordinators.dagger.components;

import dagger.Subcomponent;
import ru.hiq.coordinators.dagger.modules.ScreensModule;
import ru.hiq.coordinators.dagger.scopes.ActivityScope;
import ru.hiq.coordinators.screens.login_screen.LoginActivity;
import ru.hiq.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@ActivityScope
@Subcomponent(modules = {ScreensModule.class})
public interface IScreensComponent {
    //ICoordinatorComponent plus(CoordinatorModule module);
    void inject(MainActivity activity);
    void inject(LoginActivity activity);
}
