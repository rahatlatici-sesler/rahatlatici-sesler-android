package com.serkancay.rahatlaticisesler.main;

import android.content.Context;
import android.content.Intent;
import com.serkancay.rahatlaticisesler.BaseActivity;
import com.serkancay.rahatlaticisesler.BaseFragment;
import com.serkancay.rahatlaticisesler.R;

public class MainActivity extends BaseActivity implements MainView {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    private MainPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        mPresenter = new MainPresenter(this);
    }

    @Override
    public void setFragment(final BaseFragment fragment) {

    }
}
