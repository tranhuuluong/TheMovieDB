package com.tranhuuluong.themoviedb.repository.mapper;

import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.repository.response.MediaEntity;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/26/18.
 */

public class MediaMapper extends ModelMapper<Media, MediaEntity> {

    @Inject
    public MediaMapper() {
    }

    @Override
    public Media transform(MediaEntity mediaEntity) {
        return new Media(
                mediaEntity.id,
                mediaEntity.vote_average,
                mediaEntity.title,
                mediaEntity.poster_path,
                mediaEntity.backdrop_path
        );
    }
}
