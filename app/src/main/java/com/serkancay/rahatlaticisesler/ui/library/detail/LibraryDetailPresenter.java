package com.serkancay.rahatlaticisesler.ui.library.detail;

import android.util.Log;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryDetailPresenter {

    private LibraryDetailView mView;

    private LibraryDetailInteractor mInteractor;

    private String mSongPath;

    public LibraryDetailPresenter(LibraryDetailView view, LibraryDetailInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    public void onResume() {
        if (mView != null) {
            mView.showProgress();
        }

        mInteractor.getCategoryDetailListApiCall(mSongPath)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SongListResponse>() {
                    @Override
                    public void accept(final SongListResponse songListResponse) throws Exception {
                        if (songListResponse != null && songListResponse.getSongList() != null) {
                            mView.updateSongs(songListResponse.getSongList(), mInteractor.getAllFavorites());
                        }
                        mView.hideProgress();
                        Log.e("HATA", "liste geldi");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        mView.hideProgress();
                        Log.e("HATA", "liste gelmedi");
                    }
                });
    }

    public void onDestroy() {
        mView = null;
    }

    public void setSongPath(String songPath) {
        mSongPath = songPath;
    }

    void deleteFavorite(Song song, int position) {
        mInteractor.deleteFavorite(song);
        List<Song> songList = mInteractor.getAllFavorites();
        mView.updateFavorites(songList, position);
    }

    void addFavorite(Song song, int position) {
        mInteractor.addFavorite(song);
        List<Song> songList = mInteractor.getAllFavorites();
        mView.updateFavorites(songList, position);
    }

}
