package ru.tixon.coordinators.dagger.components;

import dagger.Subcomponent;
import ru.tixon.coordinators.dagger.modules.CoordinatorModule;
import ru.tixon.coordinators.dagger.scopes.AppScope;
import ru.tixon.coordinators.screens.login_screen.LoginPresenter;
import ru.tixon.coordinators.screens.main_screen.MainPresenter;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@AppScope
@Subcomponent(modules = {CoordinatorModule.class})
public interface ICoordinatorComponent {
    void inject(MainPresenter presenter);
    void inject(LoginPresenter presenter);
}
