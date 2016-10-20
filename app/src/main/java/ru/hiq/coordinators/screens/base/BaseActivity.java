package ru.hiq.coordinators.screens.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.hiq.coordinators.application.App;
import ru.hiq.coordinators.dagger.components.IAppComponent;

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

    protected abstract void setupComponent(IAppComponent appComponent);
}
