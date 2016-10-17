package ru.tixon.coordinators.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.tixon.coordinators.application.App;
import ru.tixon.coordinators.dagger.modules.AppModule;
import ru.tixon.coordinators.dagger.modules.ScreensModule;
import ru.tixon.coordinators.model.Model;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
@Singleton
@Component(modules = {AppModule.class})
public interface IAppComponent {
    IScreensComponent plus(ScreensModule module);
    Model getModel();
    void inject(App app);
}
