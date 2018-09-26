package com.tranhuuluong.themoviedb.presentation.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.Country;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by luongtran on 9/25/18.
 */

public class CountryVH extends RecyclerView.ViewHolder {
    @Bind(R.id.tv_country)
    TextView tvCountry;

    public CountryVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Country country) {
        String countryText = country.getCountryName() + " (" + country.getCountryCode() + ")";
        tvCountry.setText(countryText);
    }
}
