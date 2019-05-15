package com.serkancay.rahatlaticisesler.favorites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.util.ColorUtil;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FavoriteSongListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int RESOURCE = R.layout.item_favorite_song_list;

    private LayoutInflater mInflater;

    private LinearLayoutManager mLayoutManager;

    private DividerItemDecoration mItemDecoration;

    private Context mContext;

    public FavoriteSongListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View itemView = mInflater.inflate(RESOURCE, viewGroup, false);
        FavoriteHolder holder = new FavoriteHolder(itemView);
        holder.view.setBackgroundColor(ColorUtil.generateRandomColor());
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(mItemDecoration);
    }

    public static class FavoriteHolder extends ViewHolder {

        @BindView(R.id.view)
        View view;

        @BindView(R.id.seekBarVolume)
        SeekBar seekBarVolume;

        @BindView(R.id.tbPlayPause)
        ToggleButton tbPlayPause;

        @BindView(R.id.tbFavorite)
        ToggleButton tbFavorite;

        public FavoriteHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
