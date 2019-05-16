package com.serkancay.rahatlaticisesler.util;

import android.util.Log;
import com.serkancay.rahatlaticisesler.Constants;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class L {

    public static void e(String message) {
        Log.e(Constants.APP_NAME, message);
    }

    public static void d(String message) {
        Log.d(Constants.APP_NAME, message);
    }

}
