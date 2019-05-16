package com.serkancay.rahatlaticisesler.data.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FavoriteListResponse {

    @SerializedName("songs")
    private List<Song> mFavoriteSongs;

    public List<Song> getFavoriteList() {
        return mFavoriteSongs;
    }

    public static class Song {

        @SerializedName("id")
        private int mId;

        @SerializedName("song_path")
        private String mSongPath;

        public int getId() {
            return mId;
        }

        public void setId(final int id) {
            mId = id;
        }

        public String getSongPath() {
            return mSongPath;
        }

        public void setSongPath(final String songPath) {
            mSongPath = songPath;
        }
    }

}
