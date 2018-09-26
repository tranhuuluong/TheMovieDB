package com.tranhuuluong.themoviedb.domain.usecase;

import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;

import java.util.List;

/**
 * Created by luongtran on 9/25/18.
 */

public interface AppConfigUseCase {
    void getConfig(ResponseListener<Boolean> listener);

    void getCountries(ResponseListener<List<Country>> listener);
}
