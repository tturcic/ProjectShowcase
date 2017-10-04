package com.tt.projectshowcase.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.tt.projectshowcase.R;
import com.tt.projectshowcase.data.local.UserRepository;
import com.tt.projectshowcase.di.AppComponent;
import com.tt.projectshowcase.ui.base.BaseActivity;
import com.tt.projectshowcase.ui.base.RootLayout;
import com.tt.projectshowcase.ui.login.LoginActivity;

import javax.inject.Inject;

@RootLayout(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Inject UserRepository userRepository;

    @Override
    protected void setupUi(@NonNull AppComponent component, @Nullable Bundle savedInstanceState) {
        component.inject(this);

        startActivity(new Intent(this, LoginActivity.class));
    }
}
