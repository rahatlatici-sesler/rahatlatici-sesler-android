package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface FavoritesView {

    @Deprecated
    void showProgress();

    @Deprecated
    void hideProgress();

    void updateFavorites(List<Song> favoriteList);

}
