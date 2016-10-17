package ru.hiq.coordinators.dagger.components;

import dagger.Subcomponent;
import ru.hiq.coordinators.dagger.modules.CoordinatorModule;
import ru.hiq.coordinators.dagger.scopes.AppScope;
import ru.hiq.coordinators.screens.login_screen.LoginPresenter;
import ru.hiq.coordinators.screens.main_screen.MainPresenter;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@AppScope
@Subcomponent(modules = {CoordinatorModule.class})
public interface ICoordinatorComponent {
    void inject(MainPresenter presenter);
    void inject(LoginPresenter presenter);
}
