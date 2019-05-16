package com.serkancay.rahatlaticisesler.ui.library;

import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse.Category;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface LibraryView {

    void showProgress();

    void hideProgress();

    void updateCategories(List<Category> categoryList);

    void navigateToDetailScreen(Category category);

}
