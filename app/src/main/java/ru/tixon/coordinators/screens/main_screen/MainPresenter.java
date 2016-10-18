package ru.tixon.coordinators.screens.main_screen;

import android.util.Log;

import javax.inject.Inject;

import ru.tixon.coordinators.dagger.components.ICoordinatorComponent;
import ru.tixon.coordinators.dagger.components.IScreensComponent;
import ru.tixon.coordinators.dagger.modules.CoordinatorModule;
import ru.tixon.coordinators.model.Model;
import ru.tixon.coordinators.navigation.MainCoordinator;
import ru.tixon.coordinators.screens.base.BasePresenter;
import ru.tixon.coordinators.screens.login_screen.LoginActivity;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class MainPresenter extends BasePresenter implements IMainPresenter {
    private IMainView view;

    @Inject
    Model model;

    @Inject
    MainCoordinator coordinator;

    @Inject
    public MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void textClicked() {
        model.setUpdated(true);
        coordinator.start();
    }

    @Override
    public void next() {
        view.startView(LoginActivity.class);
    }

    @Override
    public void setupComponent(IScreensComponent screensComponent) {
        Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
        ICoordinatorComponent component = screensComponent.plus(new CoordinatorModule(this));
        component.inject(this);
    }
}
