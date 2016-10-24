package com.tixon.coordinators;

import com.tixon.coordinators.mock_views.LoginViewMock;
import com.tixon.coordinators.mock_views.MainViewMock;
import com.tixon.coordinators.model.Model;
import com.tixon.coordinators.navigation.LoginCoordinator;
import com.tixon.coordinators.navigation.MainCoordinator;
import com.tixon.coordinators.screens.login_screen.ILoginView;
import com.tixon.coordinators.screens.login_screen.LoginPresenter;
import com.tixon.coordinators.screens.main_screen.IMainView;
import com.tixon.coordinators.screens.main_screen.MainPresenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by tikhon.osipov on 22.10.16
 */

/**
 * Test coordinators navigation
 */
@RunWith(JUnit4.class)
public class CoordinatorsTest {
    private Model model = new Model();
    private MainPresenter mainPresenter;
    private LoginPresenter loginPresenter;

    private void setUp() {
        //create coordinators
        MainCoordinator mainCoordinator = new MainCoordinator();
        LoginCoordinator loginCoordinator = new LoginCoordinator();

        //create mock views
        IMainView mainView = new MainViewMock();
        ILoginView loginView = new LoginViewMock();

        //create presenters
        mainPresenter = new MainPresenter(mainView, mainCoordinator);
        loginPresenter = new LoginPresenter(loginView, loginCoordinator);

        //set model to presenters (and coordinators inside presenters' #setModel method)
        mainPresenter.setModel(model);
        loginPresenter.setModel(model);
    }

    @Test
    public void testCoordinators() throws Exception {
        setUp();
        mainPresenter.textClicked();
        loginPresenter.textClicked();
    }
}
