package com.tt.projectshowcase.data.local;

import com.tt.projectshowcase.data.local.models.User;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */

public interface UserRepository {

    /**
     * Returns a user if one has logged in.
     * Returns null otherwise.
     */
    @Nullable User getUser();

    /**
     * Saves user to local storage.
     */
    void saveUser(@NonNull User user);
}
