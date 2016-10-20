package ru.hiq.coordinators.navigation;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.BasePresenter;
import ru.hiq.coordinators.screens.login_screen.LoginActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public abstract class FlowCoordinator implements ICoordinator {
    private BasePresenter presenter;
    private Model model;

    protected abstract BasePresenter requestPresenter();
    protected abstract Model requestModel();

    public FlowCoordinator() {
    }

    @Override
    public void next() {
        presenter = requestPresenter();
        model = requestModel();
        if(model.isNeedLogin()) {
            model.clearLogin();
            presenter.getNavigationContext().startView(LoginActivity.class);
        }
    }
}
