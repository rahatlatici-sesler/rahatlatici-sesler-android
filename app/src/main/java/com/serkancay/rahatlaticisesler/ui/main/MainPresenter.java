package com.serkancay.rahatlaticisesler.ui.main;

import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import com.serkancay.rahatlaticisesler.ui.base.FragmentNavigation;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class MainPresenter implements FragmentNavigation.Presenter {

    private MainView mView;

    public MainPresenter(MainView view) {
        mView = view;
    }

    @Override
    public void addFragment(final BaseFragment fragment, final boolean addToBackStack) {
        mView.setFragment(fragment, addToBackStack);
    }

}
