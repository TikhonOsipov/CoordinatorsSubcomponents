package ru.hiq.coordinators.dagger.modules;

import dagger.Module;
import dagger.Provides;
import ru.hiq.coordinators.dagger.scopes.ActivityScope;
import ru.hiq.coordinators.dagger.scopes.AppScope;
import ru.hiq.coordinators.navigation.ILoginCoordinator;
import ru.hiq.coordinators.navigation.IMainCoordinator;
import ru.hiq.coordinators.navigation.LoginCoordinator;
import ru.hiq.coordinators.navigation.MainCoordinator;
import ru.hiq.coordinators.screens.login_screen.ILoginPresenter;
import ru.hiq.coordinators.screens.main_screen.IMainPresenter;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@Module
public class CoordinatorModule {
    private IMainPresenter mainPresenter;
    private ILoginPresenter loginPresenter;

    public CoordinatorModule(IMainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public CoordinatorModule(ILoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MainCoordinator
    ///////////////////////////////////////////////////////////////////////////

    @Provides
    public IMainPresenter provideMainPresenter() {
        return mainPresenter;
    }

    @Provides
    @AppScope
    public IMainCoordinator provideMainCoordinator() {
        return new MainCoordinator(mainPresenter);
    }

    ///////////////////////////////////////////////////////////////////////////
    // LoginCoordinator
    ///////////////////////////////////////////////////////////////////////////

    @Provides
    public ILoginPresenter provideLoginPresenter() {
        return loginPresenter;
    }

    @Provides
    @ActivityScope
    public ILoginCoordinator provideLoginCoordinator() {
        return new LoginCoordinator(loginPresenter);
    }
}
