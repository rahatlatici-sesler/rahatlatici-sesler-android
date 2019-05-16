package com.serkancay.rahatlaticisesler.ui.base;

import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.network.ApiHelper;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class BaseInteractor {

    private final ApiHelper mApiHelper;

    private AppDatabase mAppDatabase;

    public BaseInteractor(ApiHelper apiHelper, AppDatabase database) {
        mApiHelper = apiHelper;
        mAppDatabase = database;
    }

    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

}
