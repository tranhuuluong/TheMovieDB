package com.tranhuuluong.themoviedb.repository.http;

import com.tranhuuluong.themoviedb.repository.response.CountryEntity;
import com.tranhuuluong.themoviedb.repository.response.ImageConfigResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by luongtran on 9/25/18.
 */

public interface RetrofitAppConfigHttpServices {
    @GET("configuration")
    Call<ImageConfigResponse> getImageConfig();

    @GET("configuration/countries")
    Call<List<CountryEntity>> getCountries();

}
