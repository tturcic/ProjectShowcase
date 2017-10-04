package com.tt.projectshowcase.data.remote.models;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 *
 * Here I assume server would return message and code inside the JSON response.
 *
 */

public class LoginResponse {

    private String message;
    private int code;

    private UserDTO user;

    public LoginResponse(String message, int code, UserDTO user) {
        this.message = message;
        this.code = code;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public UserDTO getUser() {
        return user;
    }
}
