package ru.hiq.coordinators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ru.hiq.coordinators.mock_views.LoginViewMock;
import ru.hiq.coordinators.mock_views.MainViewMock;
import ru.hiq.coordinators.model.Model;
import ru.hiq.coordinators.navigation.LoginCoordinator;
import ru.hiq.coordinators.navigation.MainCoordinator;
import ru.hiq.coordinators.screens.login_screen.ILoginView;
import ru.hiq.coordinators.screens.login_screen.LoginPresenter;
import ru.hiq.coordinators.screens.main_screen.IMainView;
import ru.hiq.coordinators.screens.main_screen.MainPresenter;

/**
 * Created by tikhon.osipov on 22.10.16
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
