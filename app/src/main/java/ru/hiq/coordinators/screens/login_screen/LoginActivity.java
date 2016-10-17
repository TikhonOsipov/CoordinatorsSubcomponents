package ru.hiq.coordinators.screens.login_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import ru.hiq.coordinators.R;
import ru.hiq.coordinators.dagger.components.IAppComponent;
import ru.hiq.coordinators.dagger.components.IScreensComponent;
import ru.hiq.coordinators.dagger.modules.ScreensModule;
import ru.hiq.coordinators.screens.base.BaseActivity;

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

        /*Log.d("myLogs", "Login presenter is null? " + (presenter == null) + "; Login coordinator is null? " + (coordinator == null));
        try {
            Log.d("myLogs", "Login presenter hashcode: " + presenter.hashCode() + "; Login coordinator hashcode: " + coordinator.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
        component = appComponent.plus(new ScreensModule(this));
        component.inject(this);
        /*component = DaggerIScreensComponent.builder()
                .iAppComponent(appComponent)
                .screensModule(new ScreensModule(this))
                .build();
        component.inject(this);*/
        presenter.setupComponent(component);
    }
}
