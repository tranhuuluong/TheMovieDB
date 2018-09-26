package com.tranhuuluong.themoviedb.domain.usecase.impl;

import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.domain.model.ImageConfig;
import com.tranhuuluong.themoviedb.domain.usecase.AppConfigUseCase;
import com.tranhuuluong.themoviedb.domain.usecase.base.BaseInteractor;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;
import com.tranhuuluong.themoviedb.presentation.manager.AppConfigManager;
import com.tranhuuluong.themoviedb.repository.datastore.AppConfigDataStore;
import com.tranhuuluong.themoviedb.repository.mapper.CountryMapper;
import com.tranhuuluong.themoviedb.repository.mapper.ImageConfigMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/25/18.
 */

public class AppConfigUseCaseImpl extends BaseInteractor implements AppConfigUseCase {
    private AppConfigDataStore appConfigDataStore;
    private AppConfigManager appConfigManager;
    private ImageConfigMapper imageConfigMapper;
    private CountryMapper countryMapper;

    @Inject
    public AppConfigUseCaseImpl(AppConfigDataStore appConfigDataStore, AppConfigManager appConfigManager, ImageConfigMapper imageConfigMapper, CountryMapper countryMapper) {
        this.appConfigDataStore = appConfigDataStore;
        this.appConfigManager = appConfigManager;
        this.imageConfigMapper = imageConfigMapper;
        this.countryMapper = countryMapper;
    }

    @Override
    public void getConfig(final ResponseListener<Boolean> listener) {
        submitTask(new Runnable() {
            @Override
            public void run() {
                try {
                    ImageConfig imageConfig = imageConfigMapper.transform(appConfigDataStore.getImageConfig());
                    appConfigManager.saveImageConfig(imageConfig);
                    notifyCallback(listener, true, null);
                } catch (Exception e) {
                    notifyCallback(listener, false, e);
                }
            }
        });
    }

    @Override
    public void getCountries(final ResponseListener<List<Country>> listener) {
        submitTask(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Country> countries = countryMapper.transform(appConfigDataStore.getCountries());
                    appConfigManager.saveCountries(countries);
                    notifyCallback(listener, countries, null);
                } catch (Exception e) {
                    notifyCallback(listener, null, e);
                }
            }
        });
    }
}
