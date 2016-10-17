package ru.hiq.coordinators.navigation;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class AppCoordinator implements ICoordinator {
    private Application application;

    @Inject
    public AppCoordinator(Application application) {
        this.application = application;
    }

    @Override
    public void start() {

    }
}
