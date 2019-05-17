package com.serkancay.rahatlaticisesler;

import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.serkancay.rahatlaticisesler.data.network.TLSSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import okhttp3.OkHttpClient;

/**
 * Created by S.Serkan Cay on 17.05.2019
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpClient();
    }

    private void initOkHttpClient() {
        try {
            AndroidNetworking.initialize(getApplicationContext(),
                    new OkHttpClient().newBuilder().sslSocketFactory(new TLSSocketFactory()).build());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
