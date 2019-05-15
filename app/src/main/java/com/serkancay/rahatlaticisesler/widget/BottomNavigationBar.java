package com.serkancay.rahatlaticisesler.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.serkancay.rahatlaticisesler.R;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class BottomNavigationBar extends LinearLayout implements OnClickListener {

    public static final int MENU_FAVORITES = 0;

    public static final int MENU_LIBRARY = 1;

    private static final int RESOURCE = R.layout.layout_bottom_navigation;

    private Context mContext;

    private LinearLayout llFavoritesButton;

    private LinearLayout llLibraryButton;

    private ImageView ivFavorites;

    private ImageView ivLibrary;

    private TextView tvFavorites;

    private TextView tvLibrary;

    private LayoutInflater mInflater;

    private OnNavigationClickListener mListener;

    public BottomNavigationBar(Context context) {
        super(context);
        init(context);
    }

    public BottomNavigationBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BottomNavigationBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    @Override
    public void onClick(final View v) {
        if (llFavoritesButton == v) {
            displayFavoritesSelectedUI();
            if (mListener != null) {
                mListener.onNavigationClick(MENU_FAVORITES);
            }
        } else if (llLibraryButton == v) {
            displayLibrarySelectedUI();
            if (mListener != null) {
                mListener.onNavigationClick(MENU_LIBRARY);
            }
        }
    }

    public void setOnNavigationClickListener(OnNavigationClickListener listener) {
        mListener = listener;
    }

    private void init(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mInflater.inflate(RESOURCE, this);
        initViews();
        bindEvents();
    }

    private void initViews() {
        llFavoritesButton = findViewById(R.id.llFavoritesButton);
        llLibraryButton = findViewById(R.id.llLibraryButton);
        ivFavorites = findViewById(R.id.ivFavorites);
        ivLibrary = findViewById(R.id.ivLibrary);
        tvFavorites = findViewById(R.id.tvFavorites);
        tvLibrary = findViewById(R.id.tvLibrary);
    }

    private void bindEvents() {
        llFavoritesButton.setOnClickListener(this);
        llLibraryButton.setOnClickListener(this);
    }

    private void displayFavoritesSelectedUI() {
        ivFavorites.setColorFilter(ContextCompat.getColor(getContext(), R.color.white));
        ivLibrary.setColorFilter(ContextCompat.getColor(getContext(), R.color.light_grey));
        tvFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        tvLibrary.setTextColor(ContextCompat.getColor(getContext(), R.color.light_grey));
    }

    private void displayLibrarySelectedUI() {
        ivFavorites.setColorFilter(ContextCompat.getColor(getContext(), R.color.light_grey));
        ivLibrary.setColorFilter(ContextCompat.getColor(getContext(), R.color.white));
        tvFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.light_grey));
        tvLibrary.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
    }

    public interface OnNavigationClickListener {

        void onNavigationClick(int whichMenu);
    }
}
