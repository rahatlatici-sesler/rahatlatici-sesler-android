package com.serkancay.rahatlaticisesler.ui.splash;

import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.data.network.ApiHelper;
import com.serkancay.rahatlaticisesler.ui.base.BaseInteractor;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class SplashInteractor extends BaseInteractor {

    public SplashInteractor(final ApiHelper apiHelper,
            final AppDatabase database) {
        super(apiHelper, database);
    }

    public void saveAllFavorites(List<Song> songList) {
        getAppDatabase().songModel().insertAllFavorites(songList);
    }

    public List<Song> getAllFavorites() {
        return getAppDatabase().songModel().getAllFavorites();
    }
}
