package ru.hiq.coordinators.navigation;

import ru.hiq.coordinators.screens.base.IBaseView;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

class Navigation {
    private boolean condition;
    private Class<?> activityClass;

    static class Condition {
        private boolean condition;
        private Class<?> activityClass;

        Condition when(boolean condition) {
            this.condition = condition;
            return this;
        }

        Condition launch(Class<?> activityClass) {
            this.activityClass = activityClass;
            return this;
        }

        Navigation perform(IBaseView view) {
            if(condition) view.startView(activityClass);
            return new Navigation(this);
        }
    }

    private Navigation(Condition builder) {
        this.condition = builder.condition;
        this.activityClass = builder.activityClass;
    }
}
