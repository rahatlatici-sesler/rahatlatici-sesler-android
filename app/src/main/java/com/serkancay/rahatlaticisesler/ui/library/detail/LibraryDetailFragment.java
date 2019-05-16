package com.serkancay.rahatlaticisesler.ui.library.detail;

import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse.Category;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse.Song;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryDetailFragment extends BaseFragment implements LibraryDetailView {

    @BindView(R.id.rvSongs)
    RecyclerView rvSongs;

    private LibraryDetailPresenter mPresenter;

    private SongListAdapter mSongListAdapter;

    private List<Song> mSongList;

    private Category mCategory;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_library_detail;
    }

    @Override
    public void onCreated() {
        mSongList = new ArrayList<>();
        mSongListAdapter = new SongListAdapter(context, mSongList);
        rvSongs.setAdapter(mSongListAdapter);
        mPresenter = new LibraryDetailPresenter(this, new LibraryDetailInteractor(new AppApiHelper()));
        if (mCategory != null) {
            mPresenter.setSongPath(mCategory.getSongsPath());
        }
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
    public void updateSongs(final List<Song> songList) {
        mSongList.clear();
        mSongList.addAll(songList);
        mSongListAdapter.notifyDataSetChanged();
    }

    public void setCategory(Category category) {
        mCategory = category;
    }
}
