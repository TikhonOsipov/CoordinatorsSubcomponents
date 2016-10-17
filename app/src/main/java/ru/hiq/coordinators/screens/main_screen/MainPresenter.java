package ru.hiq.coordinators.screens.main_screen;

import android.util.Log;

import javax.inject.Inject;

import ru.hiq.coordinators.dagger.components.ICoordinatorComponent;
import ru.hiq.coordinators.dagger.components.IScreensComponent;
import ru.hiq.coordinators.dagger.modules.CoordinatorModule;
import ru.hiq.coordinators.navigation.MainCoordinator;
import ru.hiq.coordinators.screens.base.BasePresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class MainPresenter extends BasePresenter implements IMainPresenter {
    private IMainView view;
    private ICoordinatorComponent component;

    @Inject
    MainCoordinator coordinator;

    @Inject
    public MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void textClicked() {
        coordinator.start();
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
