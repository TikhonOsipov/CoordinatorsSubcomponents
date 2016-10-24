package com.tixon.coordinators.screens.login_screen;

import javax.inject.Inject;

import com.tixon.coordinators.screens.base.BasePresenter;
import com.tixon.coordinators.screens.main_screen.IMainPresenter;
import com.tixon.coordinators.screens.main_screen.IMainView;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public class MainTestPresenter extends BasePresenter implements IMainPresenter {
    private IMainView view;

    @Inject
    public MainTestPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void textClicked() {
        view.showToast("Testing!");
    }
}