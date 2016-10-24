package com.tixon.coordinators.screens.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tixon.coordinators.application.App;
import com.tixon.coordinators.dagger.components.IAppComponent;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.get(this).getAppComponent());
    }

    @Override
    public void startView(Class<?> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    @Override
    public void startViewClearTask(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void close() {
        finish();
    }

    protected abstract void setupComponent(IAppComponent appComponent);
}
