package com.tt.projectshowcase.data.local;

import dagger.Binds;
import dagger.Module;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */
@Module
public abstract class LocalStorageModule {

        @Binds
        abstract UserRepository provideUserRepository(UserRepositoryImpl userRepository);
}
