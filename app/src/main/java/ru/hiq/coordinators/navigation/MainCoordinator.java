package ru.hiq.coordinators.navigation;

import javax.inject.Inject;

import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.screens.base.IBasePresenter;
import ru.hiq.coordinators.screens.main_screen.IMainCoordinatorCallback;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class MainCoordinator extends FlowCoordinator implements IMainCoordinator, IMainCoordinatorCallback {
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
