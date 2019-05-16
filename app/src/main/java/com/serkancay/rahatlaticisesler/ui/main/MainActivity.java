package com.serkancay.rahatlaticisesler.ui.main;

import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.ui.base.BaseActivity;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.ui.favorites.FavoritesFragment;
import com.serkancay.rahatlaticisesler.ui.library.LibraryFragment;
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

    private FavoritesFragment frFavorites;

    private LibraryFragment frLibrary;

    private MainPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreated() {
        frFavorites = new FavoritesFragment();
        frLibrary = new LibraryFragment();
        mPresenter = new MainPresenter(this);
        mPresenter.addFragment(frFavorites, false);
    }

    @Override
    public void bindEvents() {
        bottomNavigationBar.setOnNavigationClickListener(mOnNavigationClickListener);
    }

    @Override
    public void setFragment(final BaseFragment fragment, boolean addToBackStack) {
        fragment.attachPresenter(mPresenter);
        replaceFragment(flContent, fragment, addToBackStack);
    }

    private BottomNavigationBar.OnNavigationClickListener mOnNavigationClickListener
            = new OnNavigationClickListener() {
        @Override
        public void onNavigationClick(final int whichMenu) {
            if (BottomNavigationBar.MENU_FAVORITES == whichMenu) {
                mPresenter.addFragment(frFavorites, false);
            } else if (BottomNavigationBar.MENU_LIBRARY == whichMenu) {
                mPresenter.addFragment(frLibrary, false);
            }
        }
    };
}
