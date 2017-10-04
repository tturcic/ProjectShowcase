package com.tt.projectshowcase.ui.base;

import android.support.annotation.StringRes;

/**
 * @author tturcic
 *         \date 4.9.2017.
 *
 *         Implemented by {@link BaseActivity}.
 *
 *         Override {@link #showHideProgress(boolean)} in each activity that uses this method.
 */
public interface BaseView {

    void showGeneralError(@StringRes int error);

    void showGeneralError(String msg);

    void showGeneralError(Throwable throwable);

    void showHideProgress(boolean show);

}
