package com.tixon.coordinators.mock_views;

import com.tixon.coordinators.screens.login_screen.ILoginView;

/**
 * Created by tikhon.osipov on 22.10.16
 */

public class LoginViewMock extends BaseMockView implements ILoginView {
    @Override
    public void makeToast(String text) {
        System.out.println("toast shown: " + text);
    }
}
