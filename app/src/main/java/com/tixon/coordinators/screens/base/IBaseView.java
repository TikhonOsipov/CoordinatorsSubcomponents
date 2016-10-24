package com.tixon.coordinators.screens.base;

/**
 * Created by tikhon.osipov on 20.10.2016
 */

public interface IBaseView {
    void startView(Class<?> activityClass);
    void startViewClearTask(Class<?> activityClass);
    void close();
}