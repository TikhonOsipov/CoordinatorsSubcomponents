package com.tixon.coordinators.navigation;

import javax.inject.Inject;

import com.tixon.coordinators.model.Model;
import com.tixon.coordinators.screens.base.IBasePresenter;
import com.tixon.coordinators.screens.main_screen.IMainCoordinatorCallback;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class MainCoordinator extends LoginFlowCoordinator implements IMainCoordinator, IMainCoordinatorCallback {
    @Inject
    Model model;

    @Inject
    public MainCoordinator() {
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
