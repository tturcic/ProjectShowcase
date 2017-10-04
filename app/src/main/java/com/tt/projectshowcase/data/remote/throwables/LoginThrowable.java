package com.tt.projectshowcase.data.remote.throwables;

import com.tt.projectshowcase.data.remote.models.LoginResponse;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public class LoginThrowable extends Throwable {

    public LoginThrowable(String msg){
        super(msg);
    }

    public LoginThrowable(LoginResponse response){
        super(response.getMessage());
    }
}
