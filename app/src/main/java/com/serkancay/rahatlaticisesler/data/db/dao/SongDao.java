package com.serkancay.rahatlaticisesler.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

@Dao
public interface SongDao {

    @Query("SELECT * FROM favorites")
    List<Song> getAllFavorites();

    @Insert
    void insertAllFavorites(List<Song> favorites);

    @Insert
    long insertFavorite(Song song);

    @Delete
    void deleteFavorite(Song song);
}
