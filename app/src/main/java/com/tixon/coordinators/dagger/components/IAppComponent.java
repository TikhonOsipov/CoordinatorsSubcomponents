package com.tixon.coordinators.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import com.tixon.coordinators.application.App;
import com.tixon.coordinators.dagger.modules.AppModule;
import com.tixon.coordinators.dagger.modules.ScreensModule;
import com.tixon.coordinators.dagger.modules.ScreensTestModule;
import com.tixon.coordinators.model.Model;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
@Singleton
@Component(modules = {AppModule.class})
public interface IAppComponent {
    IScreensComponent plus(ScreensModule module);
    IScreensTestComponent plus(ScreensTestModule module);
    Model getModel();
    void inject(App app);
}
