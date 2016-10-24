package com.tixon.coordinators.dagger.modules;

import dagger.Module;
import dagger.Provides;
import com.tixon.coordinators.dagger.scopes.ActivityScope;
import com.tixon.coordinators.navigation.LoginCoordinator;
import com.tixon.coordinators.navigation.MainCoordinator;
import com.tixon.coordinators.screens.login_screen.ILoginCoordinatorCallback;
import com.tixon.coordinators.screens.login_screen.ILoginPresenter;
import com.tixon.coordinators.screens.login_screen.ILoginView;
import com.tixon.coordinators.screens.login_screen.LoginPresenter;
import com.tixon.coordinators.screens.main_screen.IMainCoordinatorCallback;
import com.tixon.coordinators.screens.main_screen.IMainPresenter;
import com.tixon.coordinators.screens.main_screen.IMainView;
import com.tixon.coordinators.screens.main_screen.MainPresenter;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

@Module
public class ScreensModule {
    private IMainView mainView;
    private ILoginView loginView;

    public ScreensModule(IMainView mainView) {
        this.mainView = mainView;
    }

    public ScreensModule(ILoginView loginView) {
        this.loginView = loginView;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Main screen
    ///////////////////////////////////////////////////////////////////////////

    @Provides
    @ActivityScope
    public IMainView provideMainView() {
        return this.mainView;
    }

    @Provides
    @ActivityScope
    public IMainPresenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    public IMainCoordinatorCallback provideMainCoordinatorCallback(MainCoordinator coordinator) {
        return coordinator;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Login screen
    ///////////////////////////////////////////////////////////////////////////

    @Provides
    @ActivityScope
    public ILoginView provideLoginView() {
        return this.loginView;
    }

    @Provides
    @ActivityScope
    public ILoginPresenter provideLoginPresenter(LoginPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    public ILoginCoordinatorCallback provideLoginCoordinatorCallback(LoginCoordinator coordinator) {
        return coordinator;
    }
}
