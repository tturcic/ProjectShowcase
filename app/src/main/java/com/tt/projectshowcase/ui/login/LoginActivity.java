package com.tt.projectshowcase.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.tt.projectshowcase.R;
import com.tt.projectshowcase.di.AppComponent;
import com.tt.projectshowcase.ui.base.BaseActivity;
import com.tt.projectshowcase.ui.base.RootLayout;
import com.tt.projectshowcase.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */
@RootLayout(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.etEmail) EditText etEmail;
    @BindView(R.id.etPassword) EditText etPassword;
    @BindView(R.id.loginProgressBar) ProgressBar loginProgressBar;
    @BindView(R.id.btnLogin) Button btnLogin;

    @Inject LoginPresenter presenter;

    @Override
    protected void setupUi(@NonNull AppComponent component, @Nullable Bundle savedInstanceState) {
        component.inject(this);

        presenter.bind(this);
    }

    @OnClick(R.id.btnLogin) void onClickLogin(){
        presenter.login(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }

    @Override
    public void showHideProgress(boolean show) {
        etEmail.setEnabled(!show);
        etPassword.setEnabled(!show);
        btnLogin.setEnabled(!show);
        loginProgressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void goToMainScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
