package com.serkancay.rahatlaticisesler.ui.library.detail;

import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse.Song;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface LibraryDetailView {

    void showProgress();

    void hideProgress();

    void updateSongs(List<Song> songList, List<com.serkancay.rahatlaticisesler.data.db.entity.Song> favoriteSongs);

    void updateFavorites(List<com.serkancay.rahatlaticisesler.data.db.entity.Song> favoriteSongs, int position);
}
