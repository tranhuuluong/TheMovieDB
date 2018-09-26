package com.tranhuuluong.themoviedb.presentation.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tranhuuluong.themoviedb.presentation.manager.AppConfigManager;
import com.tranhuuluong.themoviedb.presentation.manager.SharedPrefAppConfigManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by luongtran on 9/26/18.
 */

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract AppConfigManager bindsAppConfigManager(SharedPrefAppConfigManager appConfigManager);

    @Provides
    @Singleton
    public static SharedPreferences provicesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
