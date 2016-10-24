package com.tixon.coordinators.navigation;

import javax.inject.Inject;

import com.tixon.coordinators.model.Model;
import com.tixon.coordinators.screens.base.IBasePresenter;
import com.tixon.coordinators.screens.base.IBaseView;
import com.tixon.coordinators.screens.login_screen.LoginActivity;
import com.tixon.coordinators.screens.main_screen.MainActivity;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

class LoginFlowCoordinator implements ICoordinator {
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

    LoginFlowCoordinator() {
    }

    @Override
    public void finish() {
        IBaseView navContext = presenter.getNavigationContext();
        if(model.needsLogin()) {
            navContext.startView(LoginActivity.class);
        } else {
            navContext.startViewClearTask(MainActivity.class);
        }
    }
}
