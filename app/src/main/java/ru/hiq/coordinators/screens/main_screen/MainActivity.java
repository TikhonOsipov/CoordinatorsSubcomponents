package ru.hiq.coordinators.screens.main_screen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import ru.hiq.coordinators.R;
import ru.hiq.coordinators.application.App;
import ru.hiq.coordinators.dagger.components.IAppComponent;
import ru.hiq.coordinators.dagger.components.IScreensComponent;
import ru.hiq.coordinators.dagger.components.IScreensTestComponent;
import ru.hiq.coordinators.dagger.modules.ScreensModule;
import ru.hiq.coordinators.dagger.modules.ScreensTestModule;
import ru.hiq.coordinators.screens.base.BaseActivity;

public class MainActivity extends BaseActivity implements IMainView {
    IScreensComponent component;
    IScreensTestComponent testComponent;

    @Inject
    IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textViewMain);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.textClicked();
            }
        });
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        if(App.get(this).usingTestScreenModule()) {
            Log.w("myLogs", getClass().getSimpleName() + ": setupComponent TEST called");
            testComponent = appComponent.plus(new ScreensTestModule(this));
            testComponent.inject(this);
        } else {
            Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
            component = appComponent.plus(new ScreensModule(this));
            component.inject(this);
        }
    }
}
