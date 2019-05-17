package com.serkancay.rahatlaticisesler.ui.favorites;

import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.manager.SoundManager;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import com.serkancay.rahatlaticisesler.ui.favorites.FavoriteSongListAdapter.Callback;
import com.serkancay.rahatlaticisesler.util.L;
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

    // TODO refactoring
    private SoundManager mSoundManager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public void onCreated() {
        mSoundManager = new SoundManager(context, 10);
        mSongList = new ArrayList<>();
        mFavoriteSongListAdapter = new FavoriteSongListAdapter(context, mSongList);
        mFavoriteSongListAdapter.setCallback(mCallback);
        rvSongs.setAdapter(mFavoriteSongListAdapter);
        mPresenter = new FavoritesPresenter(this,
                new FavoritesInteractor(new AppApiHelper(), AppDatabase.getDatabase(context)));
    }

    @Override
    public void onResumed() {
        getNavigationPresenter().setTitle(getString(R.string.ui_favorites_title));
        getNavigationPresenter().setDisplayHomeAsUpEnabled(false);
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
        mSongList.clear();
        mSongList.addAll(favoriteList);
        mFavoriteSongListAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateFavoritesWithNotifyRemoved(final List<Song> favoriteList, final int position) {
        mSongList.clear();
        mSongList.addAll(favoriteList);
        mFavoriteSongListAdapter.notifyItemRemoved(position);
    }

    private Callback mCallback = new Callback() {
        @Override
        public void onFavoriteClicked(final Song song, final boolean isChecked, final int position) {
            mPresenter.deleteFavorite(song, position);
        }

        @Override
        public void onPlayClicked(final Song song, final int position) {
            mSoundManager.playSong(song);
        }

        @Override
        public void onPauseClicked(final Song song, final int position) {
            mSoundManager.pauseSong(song);
        }

        @Override
        public void onVolumeChanged(final Song song, final float volume) {
            L.d("Volume " + volume);
            mSoundManager.setVolume(song, volume);
        }
    };

}
