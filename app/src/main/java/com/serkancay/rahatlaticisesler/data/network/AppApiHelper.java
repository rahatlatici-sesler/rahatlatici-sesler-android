package com.serkancay.rahatlaticisesler.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.serkancay.rahatlaticisesler.data.network.model.FavoriteListResponse;
import io.reactivex.Observable;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    @Override
    public Observable<FavoriteListResponse> getFavoriteListApiCall() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_FAVORITE_LIST).build()
                .getObjectObservable(FavoriteListResponse.class);
    }
}
