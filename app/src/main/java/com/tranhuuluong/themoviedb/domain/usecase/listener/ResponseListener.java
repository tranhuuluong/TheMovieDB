package com.tranhuuluong.themoviedb.domain.usecase.listener;

/**
 * Created by Dong (nguyen.dong@2359media.com) on 2/8/17.
 */
public interface ResponseListener<T> {
    void onResponse(T response, Exception e);
}
