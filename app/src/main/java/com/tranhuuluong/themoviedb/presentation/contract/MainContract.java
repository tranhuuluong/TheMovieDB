package com.tranhuuluong.themoviedb.presentation.contract;

import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.presentation.contract.base.BasePresenter;
import com.tranhuuluong.themoviedb.presentation.contract.base.BaseView;

import java.util.List;

/**
 * Created by luongtran on 9/26/18.
 */

public interface MainContract {
    interface View extends BaseView {
        void onMediasRetrieve(List<Media> medias);
    }

    interface Presenter extends BasePresenter<View> {
        void start();
    }
}
