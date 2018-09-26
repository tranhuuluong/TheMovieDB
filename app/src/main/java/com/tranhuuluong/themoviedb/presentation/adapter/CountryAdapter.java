package com.tranhuuluong.themoviedb.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.presentation.adapter.viewholder.CountryVH;
import com.tranhuuluong.themoviedb.presentation.dialog.ChooseCountryDialog;

import java.util.List;

/**
 * Created by luongtran on 9/25/18.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryVH> {
    private List<Country> countries;
    private LayoutInflater layoutInflater;
    private ChooseCountryDialog.OnCountryClickListener listener;

    public CountryAdapter(List<Country> countries, LayoutInflater layoutInflater, ChooseCountryDialog.OnCountryClickListener listener) {
        this.countries = countries;
        this.layoutInflater = layoutInflater;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryVH(layoutInflater.inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CountryVH holder, final int position) {
        final Country country = countries.get(position);
        holder.bind(country);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCountryPick(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
