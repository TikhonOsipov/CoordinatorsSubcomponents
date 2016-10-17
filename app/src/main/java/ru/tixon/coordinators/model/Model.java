package ru.tixon.coordinators.model;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 17.10.2016
 */

public class Model {
    private boolean updated = false;

    @Inject
    public Model() {
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}
