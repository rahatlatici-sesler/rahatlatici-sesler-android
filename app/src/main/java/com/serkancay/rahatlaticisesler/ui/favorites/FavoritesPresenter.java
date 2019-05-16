package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.ui.favorites.FetchFavoritesInteractor.OnFinishedListener;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FavoritesPresenter implements OnFinishedListener {

    private FavoritesView mView;
    private FetchFavoritesInteractor mInteractor;

    public FavoritesPresenter(FavoritesView view, FetchFavoritesInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    void onResume() {
        if (mView != null) {
            mView.showProgress();
        }

        mInteractor.fetchItems(this);
    }

    void onDestroy() {
        mView = null;
    }

    @Override
    public void onFinished(final List<String> items) {
        if (mView != null) {
            mView.setItems(items);
            mView.hideProgress();
        }
    }
}
