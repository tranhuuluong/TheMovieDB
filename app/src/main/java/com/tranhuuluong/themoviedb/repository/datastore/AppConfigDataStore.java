package com.tranhuuluong.themoviedb.repository.datastore;

import com.tranhuuluong.themoviedb.repository.response.CountryEntity;
import com.tranhuuluong.themoviedb.repository.response.ImageConfigResponse;

import java.util.List;

/**
 * Created by luongtran on 9/25/18.
 */

public interface AppConfigDataStore {
    ImageConfigResponse getImageConfig() throws Exception;

    List<CountryEntity> getCountries() throws Exception;
}
