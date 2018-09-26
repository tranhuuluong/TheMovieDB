package com.tranhuuluong.themoviedb.domain.usecase.impl;

import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.domain.usecase.MediaUseCase;
import com.tranhuuluong.themoviedb.domain.usecase.base.BaseInteractor;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;
import com.tranhuuluong.themoviedb.presentation.manager.AppConfigManager;
import com.tranhuuluong.themoviedb.repository.datastore.MediaDataStore;
import com.tranhuuluong.themoviedb.repository.mapper.MediaMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/26/18.
 */

public class MediaUseCaseImpl extends BaseInteractor implements MediaUseCase {
    private MediaDataStore mediaDataStore;
    private AppConfigManager appConfigManager;
    private MediaMapper mediaMapper;

    @Inject
    public MediaUseCaseImpl(MediaDataStore mediaDataStore, AppConfigManager appConfigManager, MediaMapper mediaMapper) {
        this.mediaDataStore = mediaDataStore;
        this.appConfigManager = appConfigManager;
        this.mediaMapper = mediaMapper;
    }

    @Override
    public void getUpComing(final ResponseListener<List<Media>> listener) {
        submitTask(new Runnable() {
            @Override
            public void run() {
                try {
                    notifyCallback(listener, mediaMapper.transform(mediaDataStore.getPopular(appConfigManager.getCountryCode(), 1)), null);
                } catch (Exception e) {
                    notifyCallback(listener, null, e);
                }
            }
        });
    }
}
