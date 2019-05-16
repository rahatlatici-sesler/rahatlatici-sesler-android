package com.serkancay.rahatlaticisesler.favorites;

import android.os.Handler;
import java.util.Arrays;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FetchFavoritesInteractor {

    public interface OnFinishedListener {

        void onFinished(List<String> items);
    }

    public void fetchItems(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createArrayList());
            }
        }, 2000);
    }

    // TODO dummy datas
    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }

}
