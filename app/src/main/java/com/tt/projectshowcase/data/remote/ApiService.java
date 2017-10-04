package com.tt.projectshowcase.data.remote;

import com.tt.projectshowcase.data.remote.models.LoginResponse;

import io.reactivex.Single;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 *
 * This would usually be a Retrofit interface, but I'm just mocking server for this showcase.
 */

public interface ApiService {

    Single<LoginResponse> login(String email, String password);
}
