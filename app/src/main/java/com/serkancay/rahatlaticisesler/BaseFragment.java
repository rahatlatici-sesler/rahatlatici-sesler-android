package com.serkancay.rahatlaticisesler;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class BaseFragment extends Fragment {

    private ViewGroup vgContainer;

    public Context context;

    public BaseActivity activity;

    public int getLayoutId() {
        return -1;
    }

    public void onResumed() {
    }

    public void onPaused() {
    }

    public void onDestroyed() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        activity = (BaseActivity) getActivity();
        context = activity;
        if (getLayoutId() != -1) {
            vgContainer = (ViewGroup) inflater.inflate(getLayoutId(), null);
            ButterKnife.bind(this, vgContainer);
        }
        return vgContainer;
    }

    @Override
    public void onResume() {
        super.onResume();
        onResumed();
    }

    @Override
    public void onPause() {
        super.onPause();
        onPaused();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDestroyed();
    }
}
