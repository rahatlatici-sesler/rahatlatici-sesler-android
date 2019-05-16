package com.serkancay.rahatlaticisesler.ui.library;

import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.network.ApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse;
import com.serkancay.rahatlaticisesler.ui.base.BaseInteractor;
import io.reactivex.Observable;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryInteractor extends BaseInteractor {

    public LibraryInteractor(final ApiHelper apiHelper, final AppDatabase database) {
        super(apiHelper, database);
    }

    public Observable<CategoryListResponse> getCategoryListApiCall() {
        return getApiHelper().getCategoryListApiCall();
    }
}
