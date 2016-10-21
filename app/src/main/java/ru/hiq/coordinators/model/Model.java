package ru.hiq.coordinators.model;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class Model {
    private boolean needLogin = false;

    @Inject
    public Model() {
    }

    public boolean needsLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }

    public void clearLogin() {
        setNeedLogin(false);
    }
}
