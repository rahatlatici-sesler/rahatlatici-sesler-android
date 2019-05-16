package com.serkancay.rahatlaticisesler.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.serkancay.rahatlaticisesler.data.db.dao.SongDao;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

@Database(entities = {Song.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    public abstract SongDao songModel();

    public static AppDatabase getDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "favorites")
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public static AppDatabase getMemoryDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }
}
