package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.data.network.ApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.FavoriteListResponse;
import com.serkancay.rahatlaticisesler.ui.base.BaseInteractor;
import io.reactivex.Observable;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FavoritesInteractor extends BaseInteractor {

    public FavoritesInteractor(ApiHelper apiHelper) {
        super(apiHelper);
    }

    public Observable<FavoriteListResponse> getFavoriteListApiCall() {
        return getApiHelper().getFavoriteListApiCall();
    }

}
