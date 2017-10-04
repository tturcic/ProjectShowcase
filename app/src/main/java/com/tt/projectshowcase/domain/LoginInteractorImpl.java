package com.tt.projectshowcase.domain;

import com.tt.projectshowcase.data.ObjectMapper;
import com.tt.projectshowcase.data.local.UserRepository;
import com.tt.projectshowcase.data.remote.ApiService;
import com.tt.projectshowcase.data.remote.throwables.LoginThrowable;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public class LoginInteractorImpl implements LoginInteractor {

    private final ApiService apiService;
    private final UserRepository userRepository;

    @Inject
    public LoginInteractorImpl(ApiService apiService, UserRepository userRepository) {
        this.apiService = apiService;
        this.userRepository = userRepository;
    }

    @Override
    public Completable login(String email, String password) {
        return apiService.login(email, password)
                .flatMapCompletable(response -> {
                    if (response.getCode() == 300 && response.getUser() != null) {
                        userRepository.saveUser(ObjectMapper.fromUserDTO(response.getUser()));
                        return Completable.complete();
                    } else {
                        return Completable.error(new LoginThrowable(response.getMessage()));
                    }
                });
    }
}
