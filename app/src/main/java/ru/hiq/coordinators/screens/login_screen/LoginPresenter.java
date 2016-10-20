package ru.hiq.coordinators.screens.login_screen;

import javax.inject.Inject;

import ru.hiq.coordinators.screens.base.BasePresenter;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginPresenter extends BasePresenter implements ILoginPresenter {
    private ILoginView view;
    private ILoginCoordinatorCallback coordinator;

    @Inject
    public LoginPresenter(ILoginView view, ILoginCoordinatorCallback coordinator) {
        this.view = view;
        super.setView(view);
        this.coordinator = coordinator;
    }

    @Override
    public void textClicked() {
        view.makeToast("Clicked!");
    }
}
