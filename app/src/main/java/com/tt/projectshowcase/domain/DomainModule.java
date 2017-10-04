package com.tt.projectshowcase.domain;

import dagger.Binds;
import dagger.Module;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */
@Module
public abstract class DomainModule {

    @Binds
    abstract LoginInteractor provideLoginInteractor(LoginInteractorImpl loginInteractor);

}
