package com.serkancay.rahatlaticisesler.ui.favorites;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.FavoriteListResponse.Song;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import com.serkancay.rahatlaticisesler.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class FavoritesFragment extends BaseFragment implements FavoritesView {

    @BindView(R.id.rvSongs)
    RecyclerView rvSongs;

    private FavoritesPresenter mPresenter;

    private FavoriteSongListAdapter mFavoriteSongListAdapter;

    private List<Song> mSongList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public void onCreated() {
        mSongList = new ArrayList<>();
        mFavoriteSongListAdapter = new FavoriteSongListAdapter(context, mSongList);
        rvSongs.setAdapter(mFavoriteSongListAdapter);
        mPresenter = new FavoritesPresenter(this, new FavoritesInteractor(new AppApiHelper()));
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
    public void updateFavorites(final List<Song> favoriteList) {
        Log.e("TEST", "updating favorites " + favoriteList.size());
        mSongList.clear();
        mSongList.addAll(favoriteList);
        mFavoriteSongListAdapter.notifyDataSetChanged();
    }

}
