package com.serkancay.rahatlaticisesler.ui.splash;

import android.os.Handler;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import com.serkancay.rahatlaticisesler.util.L;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class SplashPresenter {

    private static final int SPLASH_DELAY_TIME = 2000;

    private SplashView mView;

    private SplashInteractor mInteractor;

    public SplashPresenter(SplashView view, SplashInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    /**
     * Favoriler servis tarafinda sabit oldugu icin eger veritabaninda favori yoksa servisten favori listesi
     * alinip veritabanina kaydediliyor.
     */
    public void onResume() {
        List<Song> songList = mInteractor.getAllFavorites();
        if (songList.isEmpty()) {
            L.d("Song list empty");
            mInteractor.getFavoriteListApiCall().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<SongListResponse>() {
                        @Override
                        public void accept(final SongListResponse favoriteListResponse) throws Exception {
                            if (favoriteListResponse != null && favoriteListResponse.getSongList() != null) {
                                List<SongListResponse.Song> networkSongList = favoriteListResponse.getSongList();
                                List<Song> databaseSongList = new ArrayList<>();
                                for (SongListResponse.Song networkSong : networkSongList) {
                                    databaseSongList.add(new Song(networkSong.getId(), networkSong.getName(),
                                            networkSong.getSongPath()));
                                }
                                mInteractor.saveAllFavorites(databaseSongList);
                            }
                            finishWithDelay();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(final Throwable throwable) throws Exception {
                            mView.showError();
                        }
                    });

        } else {
            L.d("Song list already exists in database");
            finishWithDelay();
        }
    }

    public void finishWithDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.navigateToHome();
            }
        }, SPLASH_DELAY_TIME);
    }

    public void onDestroy() {
        mView = null;
    }
}
