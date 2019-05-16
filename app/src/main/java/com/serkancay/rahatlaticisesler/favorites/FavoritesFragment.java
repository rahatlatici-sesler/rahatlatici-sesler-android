package com.serkancay.rahatlaticisesler.favorites;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.BaseFragment;
import com.serkancay.rahatlaticisesler.R;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class FavoritesFragment extends BaseFragment implements FavoritesView {

    @BindView(R.id.rvSongs)
    RecyclerView rvSongs;

    private FavoritesPresenter mPresenter;

    private FavoriteSongListAdapter mSongListAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public void onCreated() {
        mPresenter = new FavoritesPresenter(this, new FetchFavoritesInteractor());
        mSongListAdapter = new FavoriteSongListAdapter(context);
        rvSongs.setAdapter(mSongListAdapter);
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
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(final List<String> items) {
    }
}
