package com.tt.projectshowcase.domain;

import io.reactivex.Completable;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public interface LoginInteractor {

    Completable login(String email, String password);

}
