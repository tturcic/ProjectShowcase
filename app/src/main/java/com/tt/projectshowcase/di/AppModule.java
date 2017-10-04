package com.tt.projectshowcase.di;

import android.content.Context;

import com.google.gson.Gson;
import com.tt.projectshowcase.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */
@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    @AppContext
    Context provideAppContext(){
        return app;
    }
}
