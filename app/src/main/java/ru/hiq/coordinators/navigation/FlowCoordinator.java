package ru.hiq.coordinators.navigation;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.BasePresenter;
import ru.hiq.coordinators.screens.base.IBaseView;
import ru.hiq.coordinators.screens.login_screen.LoginActivity;
import ru.hiq.coordinators.screens.main_screen.MainActivity;

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
        IBaseView navContext = presenter.getNavigationContext();
        new Navigation.Condition(navContext)
                .when(model.isNeedLogin())
                .launch(LoginActivity.class).create();
        new Navigation.Condition(navContext)
                .when(!model.isNeedLogin())
                .launch(MainActivity.class)
                .clearTask()
                .create();
    }
}
