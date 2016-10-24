package com.tixon.coordinators.dagger.modules;

import dagger.Module;
import dagger.Provides;
import com.tixon.coordinators.dagger.scopes.ActivityScope;
import com.tixon.coordinators.screens.login_screen.MainTestPresenter;
import com.tixon.coordinators.screens.main_screen.IMainPresenter;
import com.tixon.coordinators.screens.main_screen.IMainView;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

@Module
public class ScreensTestModule {
    private IMainView view;

    public ScreensTestModule(IMainView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public IMainView provideView() {
        return this.view;
    }

    @Provides
    @ActivityScope
    public IMainPresenter provideTestPresenter(MainTestPresenter testPresenter) {
        return testPresenter;
    }
}
