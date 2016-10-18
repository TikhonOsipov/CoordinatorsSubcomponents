package ru.tixon.coordinators.dagger.modules;

import dagger.Module;
import dagger.Provides;
import ru.tixon.coordinators.dagger.scopes.AppScope;
import ru.tixon.coordinators.navigation.ILoginCoordinator;
import ru.tixon.coordinators.navigation.IMainCoordinator;
import ru.tixon.coordinators.navigation.LoginCoordinator;
import ru.tixon.coordinators.navigation.MainCoordinator;
import ru.tixon.coordinators.screens.login_screen.ILoginPresenter;
import ru.tixon.coordinators.screens.main_screen.IMainPresenter;

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
    @AppScope
    public ILoginCoordinator provideLoginCoordinator() {
        return new LoginCoordinator(loginPresenter);
    }
}
