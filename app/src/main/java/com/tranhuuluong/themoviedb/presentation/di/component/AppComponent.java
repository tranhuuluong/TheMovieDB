package com.tranhuuluong.themoviedb.presentation.di.component;

import android.content.Context;

import com.tranhuuluong.themoviedb.presentation.di.module.AppModule;
import com.tranhuuluong.themoviedb.presentation.di.module.DataStoreModule;
import com.tranhuuluong.themoviedb.presentation.di.module.UseCaseModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by luongtran on 9/26/18.
 */

@Component(modules = {AppModule.class, DataStoreModule.class, UseCaseModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }

    SplashComponent getSplashActivityComponent();

    MainComponent getMainComponent();
}
