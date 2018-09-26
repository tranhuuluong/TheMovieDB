package com.tranhuuluong.themoviedb.presentation.di.module;

import com.tranhuuluong.themoviedb.presentation.contract.MainContract;
import com.tranhuuluong.themoviedb.presentation.di.ActivityScope;
import com.tranhuuluong.themoviedb.presentation.presenter.MainPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by luongtran on 9/26/18.
 */

@Module
public abstract class MainActivityModule {
    @Binds
    @ActivityScope
    abstract MainContract.Presenter bindsMainPresenter(MainPresenter presenter);
}
