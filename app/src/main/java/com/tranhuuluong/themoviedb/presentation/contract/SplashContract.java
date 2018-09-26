package com.tranhuuluong.themoviedb.presentation.contract;

import com.tranhuuluong.themoviedb.domain.model.Country;
import com.tranhuuluong.themoviedb.presentation.contract.base.BasePresenter;
import com.tranhuuluong.themoviedb.presentation.contract.base.BaseView;

import java.util.List;

/**
 * Created by luongtran on 9/25/18.
 */

public interface SplashContract {
    interface View extends BaseView {
        void displayChooseCountry(List<Country> response);

        void goToMainScreen();
    }

    interface Presenter extends BasePresenter<View> {
        void start();

        void pickCountry(Country country);
    }
}
