package com.tixon.coordinators.screens.login_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import com.tixon.coordinators.R;
import com.tixon.coordinators.dagger.components.IAppComponent;
import com.tixon.coordinators.dagger.components.IScreensComponent;
import com.tixon.coordinators.dagger.modules.ScreensModule;
import com.tixon.coordinators.screens.base.BaseActivity;

/**
 * Created by tikhon.osipov on 11.07.2016
 */
public class LoginActivity extends BaseActivity implements ILoginView {
    IScreensComponent component;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.onCreate();

        findViewById(R.id.loginText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.textClicked();
            }
        });
    }

    @Override
    public void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
        component = appComponent.plus(new ScreensModule(this));
        component.inject(this);
    }
}
