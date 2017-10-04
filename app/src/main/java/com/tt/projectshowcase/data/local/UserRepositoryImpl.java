package com.tt.projectshowcase.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tt.projectshowcase.data.local.models.User;
import com.tt.projectshowcase.di.AppContext;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public class UserRepositoryImpl implements UserRepository {

    private static final String PREFS_USER = "user";

    private final SharedPreferences prefs;
    private final Gson gson;

    @Inject
    public UserRepositoryImpl(@AppContext Context context, Gson gson){
        this.prefs = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        this.gson = gson;
    }

    @Override
    public User getUser() {
        String userJson = prefs.getString(PREFS_USER, null);
        if(userJson != null){
            return gson.fromJson(userJson, User.class);
        }
        return null;
    }

    @Override
    public void saveUser(@NonNull User user) {
        String userJson = gson.toJson(user);
        prefs.edit().putString(PREFS_USER, userJson).apply();
    }
}
