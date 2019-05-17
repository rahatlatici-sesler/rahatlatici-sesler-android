package com.serkancay.rahatlaticisesler.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import io.reactivex.Observable;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class AppApiHelper implements ApiHelper {

    private static AppApiHelper sInstance;

    public static AppApiHelper getApiHelper() {
        if (sInstance == null) {
            sInstance = new AppApiHelper();
        }
        return sInstance;
    }

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

    private AppApiHelper() {
    }

}
