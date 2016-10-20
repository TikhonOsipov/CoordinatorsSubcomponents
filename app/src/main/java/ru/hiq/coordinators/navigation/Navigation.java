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
        private boolean clearTask;
        private IBaseView view;
        private Class<?> activityClass;

        public Condition(IBaseView view) {
            this.view = view;
        }

        Condition when(boolean condition) {
            this.condition = condition;
            return this;
        }

        Condition launch(Class<?> activityClass) {
            this.activityClass = activityClass;
            return this;
        }

        Condition clearTask() {
            this.clearTask = true;
            return this;
        }

        Navigation create() {
            if(condition) {
                if(!clearTask) {
                    view.startView(activityClass);
                } else {
                    clearTask = false;
                    view.startViewClearTask(activityClass);
                }
            }
            return new Navigation(this);
        }
    }

    private Navigation(Condition builder) {
        this.condition = builder.condition;
        this.activityClass = builder.activityClass;
    }
}
