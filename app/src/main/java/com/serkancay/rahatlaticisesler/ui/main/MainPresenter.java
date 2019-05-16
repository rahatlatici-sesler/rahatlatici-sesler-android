package com.serkancay.rahatlaticisesler.ui.main;

import com.serkancay.rahatlaticisesler.BaseFragment;
import com.serkancay.rahatlaticisesler.ui.favorites.FavoritesFragment;
import com.serkancay.rahatlaticisesler.ui.library.LibraryFragment;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class MainPresenter {

    private FavoritesFragment frFavorites;

    private LibraryFragment frLibrary;

    private MainView mView;

    public MainPresenter(MainView view) {
        mView = view;
        frFavorites = new FavoritesFragment();
        frLibrary = new LibraryFragment();
    }

    public void showFavoritesFragment() {
        mView.setFragment(frFavorites);
    }

    public void showLibraryFragment() {
        mView.setFragment(frLibrary);
    }

    public BaseFragment getFavoritesFragment() {
        return frFavorites;
    }

    public BaseFragment getLibraryFragment() {
        return frLibrary;
    }

}
