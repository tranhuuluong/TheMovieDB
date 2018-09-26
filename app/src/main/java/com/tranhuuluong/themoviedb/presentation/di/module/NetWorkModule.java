package com.tranhuuluong.themoviedb.presentation.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tranhuuluong.themoviedb.BuildConfig;
import com.tranhuuluong.themoviedb.repository.http.RetrofitAppConfigHttpServices;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luongtran on 9/25/18.
 */

@Module
public abstract class NetWorkModule {
    @Provides
    @Singleton
    public static Gson providesGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd")
                .create();
    }

    @Provides
    @Singleton
    public static OkHttpClient providesOkhttpClient() {
        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                HttpUrl httpUrl = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build();
                return chain.proceed(chain.request()
                        .newBuilder()
                        .url(httpUrl)
                        .build());
            }
        };

        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(networkInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public static Retrofit providesRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    public static RetrofitAppConfigHttpServices providesRetrofitAppConfigHttpServices(Retrofit retrofit) {
        return retrofit.create(RetrofitAppConfigHttpServices.class);
    }
}
