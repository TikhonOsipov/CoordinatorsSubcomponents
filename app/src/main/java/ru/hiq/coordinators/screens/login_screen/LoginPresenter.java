package ru.hiq.coordinators.screens.login_screen;

import android.util.Log;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.BasePresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginPresenter extends BasePresenter implements ILoginPresenter {
    private ILoginView view;
    private ILoginCoordinatorCallback coordinator;

    @Inject
    Model model;

    @Inject
    public LoginPresenter(ILoginView view, ILoginCoordinatorCallback coordinator) {
        this.view = view;
        super.setView(view);
        this.coordinator = coordinator;
        coordinator.setPresenter(this);
    }

    @Override
    public void onCreate() {
        Log.d("myLogs", getClass().getSimpleName() + " onCreate(): model#" + model.hashCode());
        model.clearLogin();
    }

    @Override
    public void textClicked() {
        view.makeToast("Clicked!");
        model.clearLogin();
        coordinator.finish();
    }
}
