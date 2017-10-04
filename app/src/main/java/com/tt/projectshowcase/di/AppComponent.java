package com.tt.projectshowcase.di;

import com.tt.projectshowcase.App;
import com.tt.projectshowcase.ui.login.LoginActivity;
import com.tt.projectshowcase.ui.main.MainActivity;
import com.tt.projectshowcase.data.local.LocalStorageModule;
import com.tt.projectshowcase.data.remote.ApiModule;
import com.tt.projectshowcase.domain.DomainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */
@Singleton
@Component(modules = {ApiModule.class, DomainModule.class, LocalStorageModule.class, AppModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

}
