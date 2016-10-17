package ru.tixon.coordinators.navigation;

import android.util.Log;

import javax.inject.Inject;

import ru.tixon.coordinators.model.Model;
import ru.tixon.coordinators.screens.login_screen.ILoginPresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginCoordinator implements ILoginCoordinator {
    private ILoginCoordinatorCallbackHandler callbackHandler;
    private ILoginPresenter presenter;

    @Inject
    Model model;

    @Inject
    public LoginCoordinator(ILoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        Log.w("myLogs", getClass().getSimpleName() + ": start method called: model is null? " + (model == null));
        Log.d("myLogs", getClass().getSimpleName() + ": model#" + model.hashCode());
    }

    @Override
    public void onFinish(ILoginCoordinatorCallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }
}
