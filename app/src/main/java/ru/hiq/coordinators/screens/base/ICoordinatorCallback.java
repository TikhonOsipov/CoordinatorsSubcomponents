package ru.hiq.coordinators.screens.base;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public interface ICoordinatorCallback {
    void setPresenter(IBasePresenter presenter);
    void finish();
}
