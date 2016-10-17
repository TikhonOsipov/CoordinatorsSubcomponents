package ru.hiq.coordinators.navigation;

import android.util.Log;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.main_screen.IMainPresenter;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class MainCoordinator implements IMainCoordinator {
    private IMainPresenter presenter;

    @Inject
    Model model;

    @Inject
    public MainCoordinator(IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        Log.w("myLogs", getClass().getSimpleName() + ": start method called: model is null? " + (model == null));
        Log.d("myLogs", getClass().getSimpleName() + ": model#" + model.hashCode());
    }
}
