package com.tranhuuluong.themoviedb.presentation.di.component;

import com.tranhuuluong.themoviedb.presentation.activity.MainActivity;
import com.tranhuuluong.themoviedb.presentation.di.ActivityScope;
import com.tranhuuluong.themoviedb.presentation.di.module.MainActivityModule;

import dagger.Subcomponent;

/**
 * Created by luongtran on 9/26/18.
 */

@Subcomponent(modules = MainActivityModule.class)
@ActivityScope
public interface MainComponent {
    void inject(MainActivity activity);
}
