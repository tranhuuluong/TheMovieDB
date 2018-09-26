package com.tranhuuluong.themoviedb.presentation.contract.base;

import android.support.annotation.NonNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by luongtran on 9/25/18.
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @NonNull
    public V getView() {
        if (view == null) {
            throw new NullPointerException("MvpView reference is null. Have you called attachView()?");
        }
        return view;
    }

    @Override
    public void detachView() {
        if (view != null) {

            Type[] types =
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();

            Class<V> viewClass = (Class<V>) types[0];
            view = NoOp.of(viewClass);
        }
    }
}
