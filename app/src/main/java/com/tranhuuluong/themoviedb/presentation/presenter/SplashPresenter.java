package com.tranhuuluong.themoviedb.presentation.presenter;

import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.domain.usecase.AppConfigUseCase;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;
import com.tranhuuluong.themoviedb.presentation.contract.SplashContract;
import com.tranhuuluong.themoviedb.presentation.contract.base.BasePresenterImpl;
import com.tranhuuluong.themoviedb.presentation.manager.AppConfigManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/25/18.
 */

public class SplashPresenter extends BasePresenterImpl<SplashContract.View> implements SplashContract.Presenter {
    private AppConfigUseCase appConfigUseCase;
    private AppConfigManager appConfigManager;

    private boolean finishGettingConfig;
    private boolean finishGettingCountries;

    private List<Country> countries;

    @Inject
    public SplashPresenter(AppConfigUseCase appConfigUseCase, AppConfigManager appConfigManager) {
        this.appConfigUseCase = appConfigUseCase;
        this.appConfigManager = appConfigManager;
        countries = new ArrayList<>();
    }

    @Override
    public void start() {
        getView().showLoading();
        fetchConfig();
    }

    @Override
    public void pickCountry(Country country) {
        appConfigManager.saveCountryCode(country.getCountryCode());
        appConfigManager.setLaunchAppAlready();
        getView().goToMainScreen();
    }

    private void fetchConfig() {
        if (appConfigManager.isFirstTimeLaunchApp()) {
            getConfig();
            getCountries();
        } else {
            getView().hideLoading();
            getView().goToMainScreen();
        }
    }

    private void onFinishGettingConfig() {
        if (finishGettingConfig && finishGettingCountries) {
            getView().hideLoading();
            getView().displayChooseCountry(countries);
        }
    }

    private void getConfig() {
        appConfigUseCase.getConfig(new ResponseListener<Boolean>() {
            @Override
            public void onResponse(Boolean response, Exception e) {
                if (e == null && response) {
                    finishGettingConfig = true;
                    onFinishGettingConfig();
                } else {
                    getView().displayError();
                }
            }
        });
    }

    private void getCountries() {
        appConfigUseCase.getCountries(new ResponseListener<List<Country>>() {
            @Override
            public void onResponse(List<Country> response, Exception e) {
                if (e == null) {
                    finishGettingCountries = true;
                    countries = response;
                    onFinishGettingConfig();
                } else {
                    getView().displayError();
                }
            }
        });
    }
}
