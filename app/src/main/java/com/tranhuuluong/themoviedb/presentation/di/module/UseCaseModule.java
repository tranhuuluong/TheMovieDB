package com.tranhuuluong.themoviedb.presentation.di.module;

import com.tranhuuluong.themoviedb.domain.usecase.AppConfigUseCase;
import com.tranhuuluong.themoviedb.domain.usecase.impl.AppConfigUseCaseImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by luongtran on 9/26/18.
 */

@Module
public abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract AppConfigUseCase bindsAppConfigUseCase(AppConfigUseCaseImpl appConfigUseCase);
}
