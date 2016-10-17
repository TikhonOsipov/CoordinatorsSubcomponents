package ru.hiq.coordinators.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.hiq.coordinators.application.App;
import ru.hiq.coordinators.dagger.modules.AppModule;
import ru.hiq.coordinators.dagger.modules.ScreensModule;
import ru.hiq.coordinators.model.Model;

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
