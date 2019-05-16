package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.data.network.model.FavoriteListResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        if (mView != null) {
            mView.showProgress();
        }

        mInteractor.getFavoriteListApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FavoriteListResponse>() {
                    @Override
                    public void accept(final FavoriteListResponse favoriteListResponse) throws Exception {
                        if (favoriteListResponse != null && favoriteListResponse.getFavoriteList() != null) {
                            mView.updateFavorites(favoriteListResponse.getFavoriteList());
                        }
                        mView.hideProgress();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        mView.hideProgress();
                    }
                });
    }

    void onDestroy() {
        mView = null;
    }

}
