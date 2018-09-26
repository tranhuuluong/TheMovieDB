package com.tranhuuluong.themoviedb.repository.mapper;

import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.repository.response.CountryEntity;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/25/18.
 */

public class CountryMapper extends ModelMapper<Country, CountryEntity> {

    @Inject
    public CountryMapper() {
    }

    @Override
    public Country transform(CountryEntity countryEntity) {
        return new Country(countryEntity.iso_3166_1, countryEntity.english_name);
    }
}
