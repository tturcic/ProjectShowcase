package com.tt.projectshowcase.data.remote;

import com.tt.projectshowcase.data.remote.models.LoginResponse;
import com.tt.projectshowcase.data.remote.models.UserDTO;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public class MockApiService implements ApiService {

    @Override
    public Single<LoginResponse> login(String email, String password) {
        return Single.just(createMockResponse()).delay(1500, TimeUnit.MILLISECONDS);
    }

    private LoginResponse createMockResponse(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setBirthDate("22.04.1987");
        userDTO.setCity("Osijek");
        userDTO.setEmail("tturcic.business@gmail.com");
        userDTO.setUsername("TT");

        return new LoginResponse("User found", 200, userDTO);
    }
}
