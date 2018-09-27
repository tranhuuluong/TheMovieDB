package com.tranhuuluong.themoviedb.presentation.presenter;

import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.domain.usecase.MediaUseCase;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;
import com.tranhuuluong.themoviedb.presentation.contract.MainContract;
import com.tranhuuluong.themoviedb.presentation.contract.base.BasePresenterImpl;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/26/18.
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {
    private MediaUseCase mediaUseCase;

    @Inject
    public MainPresenter(MediaUseCase mediaUseCase) {
        this.mediaUseCase = mediaUseCase;
    }

    @Override
    public void start() {
        getView().showLoading();
        mediaUseCase.getUpComing(new ResponseListener<List<Media>>() {
            @Override
            public void onResponse(List<Media> response, Exception e) {
                getView().hideLoading();
                if (e == null) {
                    getView().onMediasRetrieve(response);
                } else {
                    getView().displayError();
                }
            }
        });
    }
}
