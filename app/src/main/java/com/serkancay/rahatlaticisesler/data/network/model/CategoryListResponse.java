package com.serkancay.rahatlaticisesler.data.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class CategoryListResponse {

    @SerializedName("categories")
    private List<Category> mCategoryList;

    public List<Category> getCategoryList() {
        return mCategoryList;
    }

    public static class Category {

        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        @SerializedName("image")
        private String mImage;

        @SerializedName("songs_path")
        private String mSongsPath;

        public int getId() {
            return mId;
        }

        public void setId(final int id) {
            mId = id;
        }

        public String getName() {
            return mName;
        }

        public void setName(final String name) {
            mName = name;
        }

        public String getImage() {
            return mImage;
        }

        public void setImage(final String image) {
            mImage = image;
        }

        public String getSongsPath() {
            return mSongsPath;
        }

        public void setSongsPath(final String songsPath) {
            mSongsPath = songsPath;
        }
    }

}
