package com.tixon.coordinators.screens.main_screen;

import javax.inject.Inject;

import com.tixon.coordinators.model.Model;
import com.tixon.coordinators.navigation.MainCoordinator;
import com.tixon.coordinators.screens.base.BasePresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class MainPresenter extends BasePresenter implements IMainPresenter {
    private IMainView view;
    private IMainCoordinatorCallback coordinator;

    @Inject
    Model model;

    @SuppressWarnings("unused")
    public void setModel(Model model) {
        this.model = model;
        ((MainCoordinator) coordinator).setModel(model);
    }

    @Inject
    public MainPresenter(IMainView view, IMainCoordinatorCallback coordinator) {
        this.view = view;
        super.setView(view);
        this.coordinator = coordinator;
        coordinator.setPresenter(this);
    }

    @Override
    public void textClicked() {
        model.setNeedLogin(true);
        coordinator.finish();
    }
}
