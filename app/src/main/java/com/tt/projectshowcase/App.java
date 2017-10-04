package com.tt.projectshowcase;

import android.app.Application;
import android.content.Context;

import com.tt.projectshowcase.di.AppComponent;
import com.tt.projectshowcase.di.AppModule;
import com.tt.projectshowcase.di.DaggerAppComponent;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();
    }

    public static App get(Context context){
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    protected AppComponent createAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
