package com.tranhuuluong.themoviedb.presentation.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.presentation.adapter.CountryAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by luongtran on 9/25/18.
 */

public class ChooseCountryDialog extends Dialog {
    public interface OnCountryClickListener {
        void onCountryPick(Country country);
    }

    @Bind(R.id.rv_country)
    RecyclerView rvCountry;

    private List<Country> countries;
    private CountryAdapter adapter;
    private OnCountryClickListener listener;

    public ChooseCountryDialog(@NonNull Context context, List<Country> countries, OnCountryClickListener listener) {
        super(context, R.style.FullScreenDialog);
        setContentView(R.layout.dialog_choose_country);
        this.countries = countries;
        this.listener = listener;
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setTitle("Choose Your Country");
        adapter = new CountryAdapter(countries, LayoutInflater.from(getContext()), listener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider_drawer_item));
        rvCountry.addItemDecoration(divider);
        rvCountry.setLayoutManager(linearLayoutManager);
        rvCountry.setAdapter(adapter);
    }

}
