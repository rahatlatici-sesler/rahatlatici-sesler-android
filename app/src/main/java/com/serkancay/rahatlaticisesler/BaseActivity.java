package com.serkancay.rahatlaticisesler;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class BaseActivity extends AppCompatActivity {

    public Context context;

    public BaseActivity activity;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activity = this;

        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        }

        onCreated();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPaused();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyed();
    }

    public int getLayoutId() {
        return -1;
    }

    public void onCreated() {
    }

    public void onResumed() {
    }

    public void onPaused() {
    }

    public void onDestroyed() {
    }
}
