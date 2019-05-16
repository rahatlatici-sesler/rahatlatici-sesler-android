package com.serkancay.rahatlaticisesler.data.network;

import com.serkancay.rahatlaticisesler.data.network.model.FavoriteListResponse;
import io.reactivex.Observable;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface ApiHelper {

    Observable<FavoriteListResponse> getFavoriteListApiCall();

}
