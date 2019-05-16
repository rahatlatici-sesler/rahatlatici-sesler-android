package com.serkancay.rahatlaticisesler.ui.library;

import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.network.AppApiHelper;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse.Category;
import com.serkancay.rahatlaticisesler.ui.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class LibraryFragment extends BaseFragment implements LibraryView {

    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

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
        rvCategories.setAdapter(mCategoryListAdapter);
        mPresenter = new LibraryPresenter(this, new LibraryInteractor(new AppApiHelper()));
    }

    @Override
    public void onResumed() {
        mPresenter.onResume();
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDestroy();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void updateCategories(final List<Category> categoryList) {
        mCategoryList.clear();
        mCategoryList.addAll(categoryList);
        mCategoryListAdapter.notifyDataSetChanged();
    }

    @Override
    public void navigateToDetailScreen(final Category category) {

    }
}
