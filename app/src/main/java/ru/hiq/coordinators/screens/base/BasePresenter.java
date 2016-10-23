package ru.hiq.coordinators.screens.base;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class BasePresenter implements IBasePresenter {
    private IBaseView baseView;

    public void setView(IBaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public IBaseView getNavigationContext() {
        return this.baseView;
    };
}
