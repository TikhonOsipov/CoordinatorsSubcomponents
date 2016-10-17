package ru.tixon.coordinators.screens.login_screen;

import android.util.Log;

import javax.inject.Inject;

import ru.tixon.coordinators.dagger.components.ICoordinatorComponent;
import ru.tixon.coordinators.dagger.components.IScreensComponent;
import ru.tixon.coordinators.dagger.modules.CoordinatorModule;
import ru.tixon.coordinators.model.Model;
import ru.tixon.coordinators.navigation.LoginCoordinator;
import ru.tixon.coordinators.screens.base.BasePresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginPresenter extends BasePresenter implements ILoginPresenter {
    private ILoginView view;
    private ICoordinatorComponent component;

    @Inject
    LoginCoordinator coordinator;

    @Inject
    Model model;

    @Inject
    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    @Override
    public void textClicked() {
        Log.w("myLogs", "coordinator is null? " + (coordinator == null));

        if(coordinator != null) {
            coordinator.start();
        }
    }

    @Override
    public void setupComponent(IScreensComponent screensComponent) {
        Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
        component = screensComponent.plus(new CoordinatorModule(this));
        component.inject(this);
        /*component = DaggerICoordinatorComponent.builder()
                .iScreensComponent(screensComponent)
                .coordinatorModule(new CoordinatorModule(this))
                .build();
        component.inject(this);*/
    }
}
