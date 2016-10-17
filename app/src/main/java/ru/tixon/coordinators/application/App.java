package ru.tixon.coordinators.application;

import android.app.Application;
import android.content.Context;

import ru.tixon.coordinators.dagger.components.DaggerIAppComponent;
import ru.tixon.coordinators.dagger.components.IAppComponent;
import ru.tixon.coordinators.dagger.modules.AppModule;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class App extends Application {
    IAppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraph();
    }

    private void buildGraph() {
        appComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public IAppComponent getAppComponent() {
        return appComponent;
    }
}
