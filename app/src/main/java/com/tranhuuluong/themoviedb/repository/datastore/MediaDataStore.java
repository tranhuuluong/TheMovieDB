package com.tranhuuluong.themoviedb.repository.datastore;

import com.tranhuuluong.themoviedb.repository.response.MediaEntity;

import java.util.List;

/**
 * Created by luongtran on 9/26/18.
 */

public interface MediaDataStore {
    List<MediaEntity> getPopular(String countryCode, int page) throws Exception;
}
