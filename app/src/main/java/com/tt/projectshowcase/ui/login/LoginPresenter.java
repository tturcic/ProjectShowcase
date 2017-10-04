package com.tt.projectshowcase.ui.login;

import com.tt.projectshowcase.R;
import com.tt.projectshowcase.domain.LoginInteractor;
import com.tt.projectshowcase.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.tt.projectshowcase.utils.StringUtils.isNullOrEmpty;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginInteractor loginInteractor;

    @Inject
    public LoginPresenter(LoginInteractor loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public void login(String email, String password) {
        if (isNullOrEmpty(email) || isNullOrEmpty(password)) {
            view.showGeneralError(R.string.login_invalid_credentials);
        } else {
            view.showHideProgress(true);
            addSubscription(createLoginObservable(email, password));
        }
    }

    private Disposable createLoginObservable(String email, String password) {
        return loginInteractor.login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.goToMainScreen(), throwable -> {
                    view.showHideProgress(false);
                    view.showGeneralError(throwable);
                });
    }


}
