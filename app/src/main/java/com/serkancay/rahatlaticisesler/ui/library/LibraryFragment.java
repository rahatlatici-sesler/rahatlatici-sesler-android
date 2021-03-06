package com.serkancay.rahatlaticisesler.ui.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.db.AppDatabase;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse.Category;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import com.serkancay.rahatlaticisesler.ui.library.CategoryListAdapter.Callback;
import com.serkancay.rahatlaticisesler.ui.library.detail.LibraryDetailFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class LibraryFragment extends BaseFragment implements LibraryView {

    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private LibraryPresenter mPresenter;

    private CategoryListAdapter mCategoryListAdapter;

    private List<Category> mCategoryList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_library;
    }

    @Override
    public void onCreated() {
        mCategoryList = new ArrayList<>();
        mCategoryListAdapter = new CategoryListAdapter(context, mCategoryList);
        mCategoryListAdapter.setCallback(mCallback);
        rvCategories.setAdapter(mCategoryListAdapter);
        mPresenter = new LibraryPresenter(this,
                new LibraryInteractor(AppApiHelper.getApiHelper(), AppDatabase.getDatabase(context)));
    }

    @Override
    public void onResumed() {
        getNavigationPresenter().setTitle(getString(R.string.ui_library_title));
        getNavigationPresenter().setDisplayHomeAsUpEnabled(false);
        mPresenter.onResume();
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        rvCategories.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        rvCategories.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateCategories(final List<Category> categoryList) {
        mCategoryList.clear();
        mCategoryList.addAll(categoryList);
        mCategoryListAdapter.notifyDataSetChanged();
    }

    @Override
    public void navigateToDetailScreen(final Category category) {
        LibraryDetailFragment frLibraryDetail = new LibraryDetailFragment();
        frLibraryDetail.setCategory(category);
        getNavigationPresenter().addFragment(frLibraryDetail, true);
        getNavigationPresenter().setTitle(category.getName());
    }

    private Callback mCallback = new Callback() {
        @Override
        public void onCategoryClicked(final Category category) {
            mPresenter.navigate(category);
        }
    };
}
