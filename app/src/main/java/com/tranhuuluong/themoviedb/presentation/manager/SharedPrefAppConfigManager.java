package com.tranhuuluong.themoviedb.presentation.manager;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.domain.model.ImageConfig;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/25/18.
 */

public class SharedPrefAppConfigManager implements AppConfigManager {
    private static final String PREF_IMAGES_CONFIG = "images-config";
    private static final String PREF_COUNTRIES = "countries";
    private static final String PREF_CURRENT_COUNTRY_CODE = "current-country-code";
    private static final String PREF_FIRST_TIME_LAUNCH = "first-time-launch";

    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Inject
    public SharedPrefAppConfigManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    @Override
    public boolean isFirstTimeLaunchApp() {
        return sharedPreferences.getBoolean(PREF_FIRST_TIME_LAUNCH, true);
    }

    @Override
    public void setLaunchAppAlready() {
        sharedPreferences.edit().putBoolean(PREF_FIRST_TIME_LAUNCH, false).apply();
    }

    @Override
    public void saveCountries(List<Country> countryList) {
        sharedPreferences.edit().putString(PREF_COUNTRIES, gson.toJson(countryList)).apply();
    }

    @Override
    public List<Country> getCountries() {
        return gson.fromJson(
                sharedPreferences.getString(PREF_COUNTRIES, null),
                new TypeToken<List<Country>>() {}.getType());
    }

    @Override
    public void saveCountryCode(String countryCode) {
        sharedPreferences.edit().putString(PREF_CURRENT_COUNTRY_CODE, countryCode).apply();
    }

    @Override
    public String getCountryCode() {
        return sharedPreferences.getString(PREF_CURRENT_COUNTRY_CODE, null);
    }

    @Override
    public void saveImageConfig(ImageConfig imageConfig) {
        sharedPreferences.edit().putString(PREF_IMAGES_CONFIG, gson.toJson(imageConfig)).apply();
    }

    @Override
    public ImageConfig getImageConfig() {
        return gson.fromJson(
                sharedPreferences.getString(PREF_IMAGES_CONFIG, null),
                ImageConfig.class);
    }
}
