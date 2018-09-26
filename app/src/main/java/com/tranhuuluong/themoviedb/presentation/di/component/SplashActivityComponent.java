package com.tranhuuluong.themoviedb.presentation.di.component;

import com.tranhuuluong.themoviedb.presentation.activity.SplashActivity;
import com.tranhuuluong.themoviedb.presentation.di.ActivityScope;
import com.tranhuuluong.themoviedb.presentation.di.module.SplashActivityModule;

import dagger.Subcomponent;

/**
 * Created by luongtran on 9/26/18.
 */

@Subcomponent(modules = SplashActivityModule.class)
@ActivityScope
public interface SplashActivityComponent {
    void inject(SplashActivity activity);
}
