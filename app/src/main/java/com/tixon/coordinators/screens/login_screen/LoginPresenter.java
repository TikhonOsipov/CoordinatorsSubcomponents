package com.tixon.coordinators.screens.login_screen;

import javax.inject.Inject;

import com.tixon.coordinators.model.Model;
import com.tixon.coordinators.navigation.LoginCoordinator;
import com.tixon.coordinators.screens.base.BasePresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginPresenter extends BasePresenter implements ILoginPresenter {
    private ILoginView view;
    private ILoginCoordinatorCallback coordinator;

    @Inject
    Model model;

    @SuppressWarnings("unused")
    public void setModel(Model model) {
        this.model = model;
        ((LoginCoordinator) coordinator).setModel(model);
    }

    @Inject
    public LoginPresenter(ILoginView view, ILoginCoordinatorCallback coordinator) {
        this.view = view;
        super.setView(view);
        this.coordinator = coordinator;
        coordinator.setPresenter(this);
    }

    @Override
    public void onCreate() {
        model.clearLogin();
    }

    @Override
    public void textClicked() {
        view.makeToast("Going back to MainActivity");
        model.clearLogin();
        coordinator.finish();
    }
}
