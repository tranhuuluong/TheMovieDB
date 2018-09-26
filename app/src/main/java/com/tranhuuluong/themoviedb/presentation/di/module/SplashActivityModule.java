package com.tranhuuluong.themoviedb.presentation.di.module;

import com.tranhuuluong.themoviedb.presentation.contract.SplashContract;
import com.tranhuuluong.themoviedb.presentation.di.ActivityScope;
import com.tranhuuluong.themoviedb.presentation.presenter.SplashPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by luongtran on 9/26/18.
 */

@Module
public abstract class SplashActivityModule {
    @Binds
    @ActivityScope
    abstract SplashContract.Presenter providesSplashPresenter(SplashPresenter splashPresenter);
}
