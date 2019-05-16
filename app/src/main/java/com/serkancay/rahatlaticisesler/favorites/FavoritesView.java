package com.serkancay.rahatlaticisesler.favorites;

import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public interface FavoritesView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

}
