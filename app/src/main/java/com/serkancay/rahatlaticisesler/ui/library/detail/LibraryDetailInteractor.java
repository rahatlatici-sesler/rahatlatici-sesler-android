package com.serkancay.rahatlaticisesler.ui.library.detail;

import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.data.network.ApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse;
import com.serkancay.rahatlaticisesler.ui.base.BaseInteractor;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryDetailInteractor extends BaseInteractor {

    public LibraryDetailInteractor(final ApiHelper apiHelper, AppDatabase database) {
        super(apiHelper, database);
    }

    public Observable<SongListResponse> getCategoryDetailListApiCall(String songPath) {
        return getApiHelper().getCategoryDetailListApiCall(songPath);
    }

    public List<Song> getAllFavorites() {
        return getAppDatabase().songModel().getAllFavorites();
    }

    public void deleteFavorite(Song song) {
        getAppDatabase().songModel().deleteFavorite(song);
    }

    public void addFavorite(Song song) {
        getAppDatabase().songModel().insertFavorite(song);
    }
}
