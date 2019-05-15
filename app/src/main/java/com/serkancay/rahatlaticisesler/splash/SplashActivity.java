package com.serkancay.rahatlaticisesler.splash;

import com.serkancay.rahatlaticisesler.BaseActivity;
import com.serkancay.rahatlaticisesler.main.MainActivity;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class SplashActivity extends BaseActivity implements SplashView {

    private SplashPresenter mPresenter;

    @Override
    public void onCreated() {
        mPresenter = new SplashPresenter(this);
        mPresenter.finishWithDelay();
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDestroy();
    }

    @Override
    public void navigateToHome() {
        MainActivity.start(context);
        finish();
    }
}
