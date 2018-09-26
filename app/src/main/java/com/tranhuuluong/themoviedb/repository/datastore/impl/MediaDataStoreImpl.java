package com.tranhuuluong.themoviedb.repository.datastore.impl;

import com.tranhuuluong.themoviedb.repository.datastore.MediaDataStore;
import com.tranhuuluong.themoviedb.repository.http.RetrofitMediaHttpService;
import com.tranhuuluong.themoviedb.repository.response.MediaEntity;
import com.tranhuuluong.themoviedb.repository.response.MediaResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

/**
 * Created by luongtran on 9/26/18.
 */

public class MediaDataStoreImpl implements MediaDataStore {

    private RetrofitMediaHttpService retrofitMediaHttpService;

    @Inject
    public MediaDataStoreImpl(RetrofitMediaHttpService retrofitMediaHttpService) {
        this.retrofitMediaHttpService = retrofitMediaHttpService;
    }

    @Override
    public List<MediaEntity> getPopular(String countryCode, int page) throws Exception {
        Response<MediaResponse> response = retrofitMediaHttpService.getPopular(countryCode, page).execute();
        if (response.isSuccessful()) {
            return response.body().results;
        } else {
            throw new Exception(response.errorBody().toString());
        }
    }
}
