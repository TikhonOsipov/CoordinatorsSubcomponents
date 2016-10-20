package ru.hiq.coordinators.screens.main_screen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import ru.hiq.coordinators.R;
import ru.hiq.coordinators.dagger.components.IAppComponent;
import ru.hiq.coordinators.dagger.components.IScreensComponent;
import ru.hiq.coordinators.dagger.modules.ScreensModule;
import ru.hiq.coordinators.screens.base.BaseActivity;

public class MainActivity extends BaseActivity implements IMainView {
    IScreensComponent component;

    @Inject
    MainPresenter presenter;

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
    protected void setupComponent(IAppComponent appComponent) {
        Log.w("myLogs", getClass().getSimpleName() + ": setupComponent called");
        component = appComponent.plus(new ScreensModule(this));
        component.inject(this);
    }
}
