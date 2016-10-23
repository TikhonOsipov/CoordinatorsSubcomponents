package ru.hiq.coordinators.mock_views;

import ru.hiq.coordinators.screens.main_screen.IMainView;

/**
 * Created by tikhon.osipov on 22.10.16
 */

public class MainViewMock extends BaseMockView implements IMainView {
    @Override
    public void showToast(String text) {
        System.out.println("toast shown: " + text);
    }
}
