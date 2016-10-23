package ru.hiq.coordinators.mock_views;

import ru.hiq.coordinators.screens.base.IBaseView;

/**
 * Created by tikhon.osipov on 22.10.16
 */

public class BaseMockView implements IBaseView {
    @Override
    public void startView(Class<?> activityClass) {
        System.out.println("View started with clear task: " + activityClass.getName());
    }

    @Override
    public void startViewClearTask(Class<?> activityClass) {
        System.out.println("View started with clear task: " + activityClass.getName());
    }

    @Override
    public void close() {

    }
}
