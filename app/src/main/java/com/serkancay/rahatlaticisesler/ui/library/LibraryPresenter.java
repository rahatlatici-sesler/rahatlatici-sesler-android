package com.serkancay.rahatlaticisesler.ui.library;

import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class LibraryPresenter {

    private LibraryView mView;

    private LibraryInteractor mInteractor;

    public LibraryPresenter(LibraryView view, LibraryInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    public void onResume() {
        if (mView != null) {
            mView.showProgress();
        }
        mInteractor.getCategoryListApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CategoryListResponse>() {
                    @Override
                    public void accept(final CategoryListResponse categoryListResponse) throws Exception {
                        if (categoryListResponse != null && categoryListResponse.getCategoryList() != null) {
                            mView.updateCategories(categoryListResponse.getCategoryList());
                        }
                        mView.hideProgress();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        mView.hideProgress();
                    }
                });
    }

    public void onDestroy() {
        mView = null;
    }

}
