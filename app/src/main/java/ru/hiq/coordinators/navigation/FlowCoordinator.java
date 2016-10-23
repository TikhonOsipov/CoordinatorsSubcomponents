package ru.hiq.coordinators.navigation;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.IBasePresenter;
import ru.hiq.coordinators.screens.base.IBaseView;
import ru.hiq.coordinators.screens.login_screen.LoginActivity;
import ru.hiq.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public class FlowCoordinator implements ICoordinator {
    private IBasePresenter presenter;

    @Inject
    Model model;

    @SuppressWarnings("unused")
    protected void setModel(Model model) {
        this.model = model;
    }

    protected void setPresenter(IBasePresenter presenter) {
        this.presenter = presenter;
    }

    FlowCoordinator() {
    }

    @Override
    public void finish() {
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
