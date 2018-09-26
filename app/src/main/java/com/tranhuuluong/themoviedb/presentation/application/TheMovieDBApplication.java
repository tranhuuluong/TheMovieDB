package com.tranhuuluong.themoviedb.presentation.application;

import android.app.Application;

import com.tranhuuluong.themoviedb.presentation.di.component.AppComponent;
import com.tranhuuluong.themoviedb.presentation.di.component.DaggerAppComponent;

/**
 * Created by luongtran on 9/26/18.
 */

public class TheMovieDBApplication extends Application {

    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .context(this)
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
