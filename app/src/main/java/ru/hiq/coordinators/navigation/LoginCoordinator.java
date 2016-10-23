package ru.hiq.coordinators.navigation;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.IBasePresenter;
import ru.hiq.coordinators.screens.login_screen.ILoginCoordinatorCallback;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginCoordinator extends LoginFlowCoordinator implements ILoginCoordinator, ILoginCoordinatorCallback {
    @Inject
    Model model;

    @Inject
    public LoginCoordinator() {
        super();
    }

    @Override
    public void setModel(Model model) {
        super.setModel(model);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void setPresenter(IBasePresenter presenter) {
        super.setPresenter(presenter);
    }
}
