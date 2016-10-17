package ru.tixon.coordinators.dagger.modules;

import dagger.Module;
import dagger.Provides;
import ru.tixon.coordinators.dagger.scopes.ActivityScope;
import ru.tixon.coordinators.screens.login_screen.ILoginPresenter;
import ru.tixon.coordinators.screens.login_screen.ILoginView;
import ru.tixon.coordinators.screens.login_screen.LoginPresenter;
import ru.tixon.coordinators.screens.main_screen.IMainPresenter;
import ru.tixon.coordinators.screens.main_screen.IMainView;
import ru.tixon.coordinators.screens.main_screen.MainPresenter;

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

    @Provides
    public IMainView provideMainView() {
        return mainView;
    }

    @Provides
    @ActivityScope
    public IMainPresenter provideMainPresenter() {
        return new MainPresenter(mainView);
    }

    @Provides
    public ILoginView provideLoginView() {
        return loginView;
    }

    @Provides
    @ActivityScope
    public ILoginPresenter provideLoginPresenter() {
        return new LoginPresenter(loginView);
    }
}
