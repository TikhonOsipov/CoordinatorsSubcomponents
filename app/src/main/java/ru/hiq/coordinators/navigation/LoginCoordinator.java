package ru.hiq.coordinators.navigation;

import android.util.Log;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.BasePresenter;
import ru.hiq.coordinators.screens.login_screen.ILoginCoordinatorCallback;
import ru.hiq.coordinators.screens.login_screen.LoginPresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginCoordinator extends FlowCoordinator implements ILoginCoordinator, ILoginCoordinatorCallback {
    private LoginPresenter presenter;

    @Inject
    Model model;

    @Inject
    public LoginCoordinator() {
        super();
    }

    @Override
    public void start() {
        Log.w("myLogs", getClass().getSimpleName() + ": start method called: model is null? " + (model == null));
        Log.d("myLogs", getClass().getSimpleName() + ": model#" + model.hashCode());
    }

    @Override
    public void finish() {
        super.next();
        Log.w("myLogs", getClass().getSimpleName() + ": start method called: model is null? " + (model == null));
        //Log.d("myLogs", getClass().getSimpleName() + ": model#" + model.hashCode());
        Log.w("myLogs", getClass().getSimpleName() + ": presenter#" + presenter.hashCode());
        Log.w("myLogs", getClass().getSimpleName() + " finish called");
    }

    @Override
    public BasePresenter requestPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (LoginPresenter) presenter;
    }

    @Override
    protected Model requestModel() {
        return model;
    }
}
