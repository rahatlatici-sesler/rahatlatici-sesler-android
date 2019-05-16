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

    }

}
