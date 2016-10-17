package ru.tixon.coordinators.screens.login_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import ru.tixon.coordinators.R;
import ru.tixon.coordinators.dagger.components.IAppComponent;
import ru.tixon.coordinators.dagger.components.IScreensComponent;
import ru.tixon.coordinators.dagger.modules.ScreensModule;
import ru.tixon.coordinators.screens.base.BaseActivity;

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

        findViewById(R.id.loginText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.textClicked();
            }
        });
    }

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
        component = appComponent.plus(new ScreensModule(this));
        component.inject(this);
        presenter.setupComponent(component);
    }
}
