package com.tranhuuluong.themoviedb.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.presentation.adapter.MovieAdapter;
import com.tranhuuluong.themoviedb.presentation.application.TheMovieDBApplication;
import com.tranhuuluong.themoviedb.presentation.contract.MainContract;
import com.tranhuuluong.themoviedb.presentation.manager.AppConfigManager;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Bind(R.id.rv_upcoming)
    RecyclerView rvUpcoming;

    @Inject
    MainContract.Presenter presenter;

    @Inject
    AppConfigManager appConfigManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TheMovieDBApplication) getApplication()).getAppComponent()
                .getMainComponent()
                .inject(this);

        ButterKnife.bind(this);
        presenter.attachView(this);
        presenter.start();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void displayError() {

    }

    @Override
    public void onMediasRetrieve(List<Media> medias) {
        MovieAdapter adapter = new MovieAdapter(medias, LayoutInflater.from(this), appConfigManager.getImageConfig());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_drawer_item));
        rvUpcoming.setLayoutManager(linearLayoutManager);
        rvUpcoming.addItemDecoration(divider);
        rvUpcoming.setAdapter(adapter);
    }
}
