package com.tixon.coordinators.dagger.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.tixon.coordinators.model.Model;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
@Module
public class AppModule {
    private Application app;

    private Model model;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public Model provideModel() {
        if(model == null) model = new Model();
        return model;
    }
}
