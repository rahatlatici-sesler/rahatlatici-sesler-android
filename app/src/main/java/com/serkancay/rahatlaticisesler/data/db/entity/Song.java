package com.serkancay.rahatlaticisesler.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

@Entity(tableName = "favorites")
public class Song {

    @PrimaryKey
    public int id;

    public String name;

    public String song_path;

    public Song(int id, String name, String song_path) {
        this.id = id;
        this.name = name;
        this.song_path = song_path;
    }

}
