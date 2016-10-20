package ru.hiq.coordinators.dagger.components;

import dagger.Subcomponent;
import ru.hiq.coordinators.dagger.modules.ScreensTestModule;
import ru.hiq.coordinators.dagger.scopes.ActivityScope;
import ru.hiq.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

@ActivityScope
@Subcomponent(modules = {ScreensTestModule.class})
public interface IScreensTestComponent {
    void inject(MainActivity activity);
}
