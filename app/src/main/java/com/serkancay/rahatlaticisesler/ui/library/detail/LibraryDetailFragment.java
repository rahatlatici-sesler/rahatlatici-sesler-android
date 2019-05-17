package com.serkancay.rahatlaticisesler.ui.library.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse.Category;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse.Song;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import com.serkancay.rahatlaticisesler.ui.library.detail.SongListAdapter.Callback;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryDetailFragment extends BaseFragment implements LibraryDetailView {

    @BindView(R.id.rvSongs)
    RecyclerView rvSongs;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private LibraryDetailPresenter mPresenter;

    private SongListAdapter mSongListAdapter;

    private List<Song> mNetworkSongList;

    private List<com.serkancay.rahatlaticisesler.data.db.entity.Song> mFavoriteSongList;

    private Category mCategory;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_library_detail;
    }

    @Override
    public void onCreated() {
        mNetworkSongList = new ArrayList<>();
        mFavoriteSongList = new ArrayList<>();
        mSongListAdapter = new SongListAdapter(context, mNetworkSongList, mFavoriteSongList);
        mSongListAdapter.setCallback(mCallback);
        rvSongs.setAdapter(mSongListAdapter);
        mPresenter = new LibraryDetailPresenter(this,
                new LibraryDetailInteractor(AppApiHelper.getApiHelper(), AppDatabase.getDatabase(context)));
        if (mCategory != null) {
            mPresenter.setSongPath(mCategory.getSongsPath());
        }
    }

    @Override
    public void onResumed() {
        getNavigationPresenter().setTitle(mCategory.getName());
        getNavigationPresenter().setDisplayHomeAsUpEnabled(true);
        mPresenter.onResume();
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        rvSongs.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        rvSongs.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateSongs(final List<Song> songList,
            List<com.serkancay.rahatlaticisesler.data.db.entity.Song> favoriteSongList) {
        mNetworkSongList.clear();
        mNetworkSongList.addAll(songList);
        mFavoriteSongList.clear();
        mFavoriteSongList.addAll(favoriteSongList);
        mSongListAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateFavorites(
            final List<com.serkancay.rahatlaticisesler.data.db.entity.Song> favoriteSongs, final int position) {
        mFavoriteSongList.clear();
        mFavoriteSongList.addAll(favoriteSongs);
        mSongListAdapter.notifyDataSetChanged();
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    private Callback mCallback = new Callback() {
        @Override
        public void onFavoriteClicked(final com.serkancay.rahatlaticisesler.data.db.entity.Song song,
                final boolean isChecked,
                final int position) {
            if (isChecked) {
                mPresenter.addFavorite(song, position);
            } else {
                mPresenter.deleteFavorite(song, position);
            }
        }
    };
}
