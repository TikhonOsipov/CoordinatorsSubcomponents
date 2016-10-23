package ru.hiq.coordinators.model;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class Model {
    private boolean needLogin = false;
    private boolean paymentSelected = false;

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

    public boolean paymentWasSelected() {
        return paymentSelected;
    }

    public void setPaymentSelected(boolean selected) {
        this.paymentSelected = selected;
    }

    public void clearSelectedPayment() {
        setPaymentSelected(false);
    }
}
