package com.tt.projectshowcase.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tt.projectshowcase.App;
import com.tt.projectshowcase.R;
import com.tt.projectshowcase.di.AppComponent;

import java.io.IOException;

import butterknife.ButterKnife;

/**
 * @author tturcic
 *         \date 30.8.2017.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inflateLayout();

        setupUi(getAppComponent(), savedInstanceState);
    }

    private void inflateLayout(){
        RootLayout rootLayout = getClass().getAnnotation(RootLayout.class);
        if(rootLayout != null && rootLayout.value() != 0){
            setContentView(rootLayout.value());
            ButterKnife.bind(this);
        }
    }

    /**
     * Called after onCreate().
     *
     * @param component - app component that activity can use to inject itself.
     * @param savedInstanceState - savedInstanceState.
     */
    protected abstract void setupUi(@NonNull AppComponent component, @Nullable Bundle savedInstanceState);

    protected AppComponent getAppComponent(){
        return App.get(this).getAppComponent();
    }

    @Override
    public void showGeneralError(int error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGeneralError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGeneralError(Throwable throwable) {
        if (throwable instanceof IOException) {
            showGeneralError(R.string.error_internet);
        } else {
            showGeneralError(R.string.error_server);
        }
    }

    @Override
    public void showHideProgress(boolean show) {

    }

}
