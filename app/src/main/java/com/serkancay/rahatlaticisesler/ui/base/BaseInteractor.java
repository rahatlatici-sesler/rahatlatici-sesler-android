package com.serkancay.rahatlaticisesler.ui.base;

import com.serkancay.rahatlaticisesler.data.network.ApiHelper;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class BaseInteractor {

    private final ApiHelper mApiHelper;

    public BaseInteractor(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }

    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

}
