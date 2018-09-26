package com.tranhuuluong.themoviedb.domain.usecase;

import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;

import java.util.List;

/**
 * Created by luongtran on 9/26/18.
 */

public interface MediaUseCase {
    void getUpComing(ResponseListener<List<Media>> listener);
}
