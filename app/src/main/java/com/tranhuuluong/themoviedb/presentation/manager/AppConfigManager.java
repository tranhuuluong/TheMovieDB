package com.tranhuuluong.themoviedb.presentation.manager;

import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.domain.model.ImageConfig;

import java.util.List;

/**
 * Created by luongtran on 9/25/18.
 */

public interface AppConfigManager {
    boolean isFirstTimeLaunchApp();

    void setLaunchAppAlready();

    void saveCountries(List<Country> countryList);

    List<Country> getCountries();

    void saveCountryCode(String countryCode);

    String getCountryCode();

    void saveImageConfig(ImageConfig imageConfig);

    ImageConfig getImageConfig();
}
