package com.tranhuuluong.themoviedb.repository.datastore.impl;

import com.tranhuuluong.themoviedb.repository.datastore.AppConfigDataStore;
import com.tranhuuluong.themoviedb.repository.http.RetrofitAppConfigHttpService;
import com.tranhuuluong.themoviedb.repository.response.CountryEntity;
import com.tranhuuluong.themoviedb.repository.response.ImageConfigResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

/**
 * Created by luongtran on 9/25/18.
 */

public class AppConfigDataStoreImpl implements AppConfigDataStore {
    private RetrofitAppConfigHttpService retrofitAppconfigHttpServices;

    @Inject
    public AppConfigDataStoreImpl(RetrofitAppConfigHttpService retrofitAppconfigHttpServices) {
        this.retrofitAppconfigHttpServices = retrofitAppconfigHttpServices;
    }

    @Override
    public ImageConfigResponse getImageConfig() throws Exception {
        Response<ImageConfigResponse> response = retrofitAppconfigHttpServices.getImageConfig().execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new Exception(response.errorBody().toString());
        }
    }

    @Override
    public List<CountryEntity> getCountries() throws Exception {
        Response<List<CountryEntity>> response = retrofitAppconfigHttpServices.getCountries().execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new Exception(response.errorBody().toString());
        }
    }
}
