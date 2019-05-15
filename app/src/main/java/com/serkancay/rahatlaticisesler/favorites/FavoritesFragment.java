package com.serkancay.rahatlaticisesler.favorites;

import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.BaseFragment;
import com.serkancay.rahatlaticisesler.R;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class FavoritesFragment extends BaseFragment {

    @BindView(R.id.rvSongs)
    RecyclerView rvSongs;

    private FavoriteSongListAdapter mSongListAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public void onCreated() {
        mSongListAdapter = new FavoriteSongListAdapter(context);
        rvSongs.setAdapter(mSongListAdapter);
    }
}
