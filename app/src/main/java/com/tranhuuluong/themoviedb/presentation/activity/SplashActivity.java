package com.tranhuuluong.themoviedb.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.presentation.application.TheMovieDBApplication;
import com.tranhuuluong.themoviedb.presentation.contract.SplashContract;
import com.tranhuuluong.themoviedb.presentation.dialog.ChooseCountryDialog;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by luongtran on 9/25/18.
 */

public class SplashActivity extends AppCompatActivity implements SplashContract.View, ChooseCountryDialog.OnCountryClickListener {
    @Bind(R.id.pb_loading)
    View pbLoading;

    @Inject
    SplashContract.Presenter presenter;

    private ChooseCountryDialog chooseCountryDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ((TheMovieDBApplication) getApplication())
                .getAppComponent()
                .getSplashActivityComponent()
                .inject(this);

        ButterKnife.bind(this);

        presenter.attachView(this);
        presenter.start();
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void displayError() {

    }

    @Override
    public void displayChooseCountry(List<Country> response) {
        chooseCountryDialog = new ChooseCountryDialog(this, response, this);
        chooseCountryDialog.setTitle("Choose Your Country");
        chooseCountryDialog.show();
    }

    @Override
    public void goToMainScreen() {
        finish();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCountryPick(Country country) {
        chooseCountryDialog.dismiss();
        Toast.makeText(this, country.getCountryName(), Toast.LENGTH_SHORT).show();
        presenter.pickCountry(country);
    }
}
