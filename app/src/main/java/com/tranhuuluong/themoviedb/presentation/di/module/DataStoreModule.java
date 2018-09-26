package com.tranhuuluong.themoviedb.presentation.di.module;

import com.tranhuuluong.themoviedb.repository.datastore.AppConfigDataStore;
import com.tranhuuluong.themoviedb.repository.datastore.impl.AppConfigDataStoreImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by luongtran on 9/26/18.
 */

@Module(includes = NetWorkModule.class)
public abstract class DataStoreModule {
    @Binds
    @Singleton
    abstract AppConfigDataStore bindsAppConfigDataStore(AppConfigDataStoreImpl appConfigDataStore);
}
