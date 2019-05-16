package com.serkancay.rahatlaticisesler.ui.favorites;

import com.serkancay.rahatlaticisesler.data.network.model.FavoriteListResponse.Song;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface FavoritesView {

    void showProgress();

    void hideProgress();

    void updateFavorites(List<Song> favoriteList);

}
