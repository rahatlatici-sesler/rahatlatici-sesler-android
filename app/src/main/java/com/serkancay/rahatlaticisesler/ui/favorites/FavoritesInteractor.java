package com.serkancay.rahatlaticisesler.ui.favorites;

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

public class FavoritesInteractor extends BaseInteractor {

    public FavoritesInteractor(ApiHelper apiHelper, AppDatabase database) {
        super(apiHelper, database);
    }

    /**
     * Favorilerim ekrani sadece veritabani ile iliskili oldugu icin kullanimdan kaldirilmistir.
     */
    @Deprecated
    public Observable<SongListResponse> getFavoriteListApiCall() {
        return getApiHelper().getFavoriteListApiCall();
    }

    public List<Song> getAllFavorites() {
        return getAppDatabase().songModel().getAllFavorites();
    }

    public void deleteFavorite(Song song) {
        getAppDatabase().songModel().deleteFavorite(song);
    }

}
