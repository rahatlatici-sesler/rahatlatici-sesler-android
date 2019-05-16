package com.serkancay.rahatlaticisesler.data.network;

import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import io.reactivex.Observable;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface ApiHelper {

    Observable<SongListResponse> getFavoriteListApiCall();

    Observable<CategoryListResponse> getCategoryListApiCall();

    Observable<SongListResponse> getCategoryDetailListApiCall(String songPath);
}
