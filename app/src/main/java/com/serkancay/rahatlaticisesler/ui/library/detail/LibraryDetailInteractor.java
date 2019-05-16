package com.serkancay.rahatlaticisesler.ui.library.detail;

import com.serkancay.rahatlaticisesler.data.network.ApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import com.serkancay.rahatlaticisesler.ui.base.BaseInteractor;
import io.reactivex.Observable;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryDetailInteractor extends BaseInteractor {

    public LibraryDetailInteractor(final ApiHelper apiHelper) {
        super(apiHelper);
    }

    public Observable<SongListResponse> getCategoryDetailListApiCall(String songPath) {
        return getApiHelper().getCategoryDetailListApiCall(songPath);
    }
}
