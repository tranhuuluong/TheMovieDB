package com.tranhuuluong.themoviedb.repository.http;

import com.tranhuuluong.themoviedb.repository.response.MediaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by luongtran on 9/26/18.
 */

public interface RetrofitMediaHttpService {
    @GET("movie/popular")
    Call<MediaResponse> getPopular(@Query("region") String countryCode, @Query("page") int page);
}
