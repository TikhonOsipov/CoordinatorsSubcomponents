package com.tixon.coordinators.application;

import android.app.Application;
import android.content.Context;

import com.tixon.coordinators.dagger.components.DaggerIAppComponent;
import com.tixon.coordinators.dagger.components.IAppComponent;
import com.tixon.coordinators.dagger.modules.AppModule;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class App extends Application {
    IAppComponent appComponent;
    private boolean useTestScreenModule;

    public boolean usingTestScreenModule() {
        return useTestScreenModule;
    }

    public void setUseTestScreenModule(boolean useTestScreenModule) {
        this.useTestScreenModule = useTestScreenModule;
    }

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
