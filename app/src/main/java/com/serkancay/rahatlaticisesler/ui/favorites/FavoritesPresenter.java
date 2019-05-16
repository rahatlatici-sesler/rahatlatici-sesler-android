package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
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
                .subscribe(new Consumer<SongListResponse>() {
                    @Override
                    public void accept(final SongListResponse favoriteListResponse) throws Exception {
                        if (favoriteListResponse != null && favoriteListResponse.getSongList() != null) {
                            mView.updateFavorites(favoriteListResponse.getSongList());
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
