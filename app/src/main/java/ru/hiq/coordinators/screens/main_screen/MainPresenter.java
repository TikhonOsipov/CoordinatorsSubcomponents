package ru.hiq.coordinators.screens.main_screen;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.navigation.MainCoordinator;
import ru.hiq.coordinators.screens.base.BasePresenter;

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
