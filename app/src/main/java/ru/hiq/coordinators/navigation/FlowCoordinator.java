package ru.hiq.coordinators.navigation;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.BasePresenter;
import ru.hiq.coordinators.screens.login_screen.LoginActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public abstract class FlowCoordinator implements ICoordinator {
    private BasePresenter presenter;

    @Inject
    Model model;

    protected abstract BasePresenter requestPresenter();

    public FlowCoordinator() {
    }

    @Override
    public void finish() {
        presenter = requestPresenter();
        if(model.isNeedLogin()) {
            model.clearLogin();
            presenter.getNavigationContext().startView(LoginActivity.class); //todo wrap this in interface
        }
    }
}
