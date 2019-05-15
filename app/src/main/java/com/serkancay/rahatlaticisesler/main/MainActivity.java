package com.serkancay.rahatlaticisesler.main;

import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.BaseActivity;
import com.serkancay.rahatlaticisesler.BaseFragment;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.widget.BottomNavigationBar;
import com.serkancay.rahatlaticisesler.widget.BottomNavigationBar.OnNavigationClickListener;

public class MainActivity extends BaseActivity implements MainView {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @BindView(R.id.flContent)
    FrameLayout flContent;

    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar bottomNavigationBar;

    private MainPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        mPresenter = new MainPresenter(this);
        mPresenter.showFavoritesFragment();
    }

    @Override
    public void bindEvents() {
        bottomNavigationBar.setOnNavigationClickListener(mOnNavigationClickListener);
    }

    @Override
    public void setFragment(final BaseFragment fragment) {
        replaceFragment(flContent, fragment, false);
    }

    private BottomNavigationBar.OnNavigationClickListener mOnNavigationClickListener
            = new OnNavigationClickListener() {
        @Override
        public void onNavigationClick(final int whichMenu) {
            if (BottomNavigationBar.MENU_FAVORITES == whichMenu) {
                mPresenter.showFavoritesFragment();
            } else if (BottomNavigationBar.MENU_LIBRARY == whichMenu) {
                mPresenter.showLibraryFragment();
            }
        }
    };
}
