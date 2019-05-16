package com.serkancay.rahatlaticisesler.ui.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.network.model.CategoryListResponse.Category;
import com.serkancay.rahatlaticisesler.ui.library.CategoryListAdapter.CategoryHolder;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class CategoryListAdapter extends Adapter<CategoryHolder> {

    private static final int RESOURCE = R.layout.item_category_list;

    private List<Category> mCategoryList;

    private LayoutInflater mInflater;

    private LinearLayoutManager mLayoutManager;

    private Context mContext;

    public CategoryListAdapter(Context context, List<Category> categoryList) {
        mInflater = LayoutInflater.from(context);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mContext = context;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View item = mInflater.inflate(RESOURCE, viewGroup, false);
        CategoryHolder holder = new CategoryHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryHolder categoryHolder, final int i) {

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public static class CategoryHolder extends ViewHolder {

        @BindView(R.id.flRootButton)
        FrameLayout flRootButton;

        @BindView(R.id.ivBackground)
        ImageView ivBackground;

        @BindView(R.id.tvName)
        TextView tvName;

        CategoryHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
