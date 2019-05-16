package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FavoritesPresenter {

    private FavoritesView mView;

    private FavoritesInteractor mInteractor;

    public FavoritesPresenter(FavoritesView view, FavoritesInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    void onResume() {

        List<Song> songList = mInteractor.getAllFavorites();
        mView.updateFavorites(songList);
    }

    void onDestroy() {
        mView = null;
    }

}
