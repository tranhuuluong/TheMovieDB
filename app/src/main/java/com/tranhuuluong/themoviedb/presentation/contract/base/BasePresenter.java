package com.tranhuuluong.themoviedb.presentation.contract.base;

/**
 * Created by luongtran on 9/25/18.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
