package com.serkancay.rahatlaticisesler.ui.splash;

import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.ui.base.BaseActivity;
import com.serkancay.rahatlaticisesler.ui.main.MainActivity;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class SplashActivity extends BaseActivity implements SplashView {

    private SplashPresenter mPresenter;

    @Override
    public void onCreated() {
        mPresenter = new SplashPresenter(this,
                new SplashInteractor(AppApiHelper.getApiHelper(), AppDatabase.getDatabase(context)));
    }

    @Override
    public void onResumed() {
        mPresenter.onResume();
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

    @Override
    public void showError() {

    }
}
