package ru.hiq.coordinators.navigation;

import android.util.Log;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.BasePresenter;
import ru.hiq.coordinators.screens.main_screen.IMainCoordinatorCallback;
import ru.hiq.coordinators.screens.main_screen.MainPresenter;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class MainCoordinator extends FlowCoordinator implements IMainCoordinator, IMainCoordinatorCallback {
    private MainPresenter presenter;

    @Inject
    Model model;

    @Inject
    public MainCoordinator() {
        super();
    }

    @Override
    public void start() {
        /*Log.w("myLogs", getClass().getSimpleName() + ": start method called: model is null? " + (model == null));
        //Log.d("myLogs", getClass().getSimpleName() + ": model#" + model.hashCode());
        //Log.d("myLogs", getClass().getSimpleName() + ": presenter#" + presenter.hashCode());*/
    }

    @Override
    public void finish() {
        Log.w("myLogs", getClass().getSimpleName() + ": model#" + model.hashCode());
        Log.w("myLogs", getClass().getSimpleName() + ": presenter#" + presenter.hashCode());
        Log.w("myLogs", getClass().getSimpleName() + " finish called");
        super.finish();
    }

    @Override
    public BasePresenter requestPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (MainPresenter) presenter;
    }
}
