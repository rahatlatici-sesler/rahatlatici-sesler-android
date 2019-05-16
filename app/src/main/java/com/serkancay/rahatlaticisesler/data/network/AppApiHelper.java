package com.serkancay.rahatlaticisesler.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import io.reactivex.Observable;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    @Override
    public Observable<SongListResponse> getFavoriteListApiCall() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_FAVORITE_LIST)
                .build()
                .getObjectObservable(SongListResponse.class);
    }

    @Override
    public Observable<CategoryListResponse> getCategoryListApiCall() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_CATEGORY_LIST)
                .build()
                .getObjectObservable(CategoryListResponse.class);
    }

    @Override
    public Observable<SongListResponse> getCategoryDetailListApiCall(String songPath) {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_CATEGORY_LIST + "/" + songPath)
                .build()
                .getObjectObservable(SongListResponse.class);
    }
}
