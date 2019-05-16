package com.serkancay.rahatlaticisesler.ui.favorites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.ui.favorites.FavoriteSongListAdapter.FavoriteHolder;
import com.serkancay.rahatlaticisesler.util.AnimationUtil;
import com.serkancay.rahatlaticisesler.util.ColorUtil;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class FavoriteSongListAdapter extends RecyclerView.Adapter<FavoriteHolder> {

    private static final int RESOURCE = R.layout.item_favorite_song_list;

    private List<Song> mSongList;

    private LayoutInflater mInflater;

    private LinearLayoutManager mLayoutManager;

    private DividerItemDecoration mItemDecoration;

    private ScaleAnimation mScaleAnimation;

    private Context mContext;

    public FavoriteSongListAdapter(Context context, List<Song> songList) {
        mInflater = LayoutInflater.from(context);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        mContext = context;
        mScaleAnimation = AnimationUtil.createScaleAnimation(500);
        mSongList = songList;
    }

    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View itemView = mInflater.inflate(RESOURCE, viewGroup, false);
        FavoriteHolder holder = new FavoriteHolder(itemView);
        holder.view.setBackgroundColor(ColorUtil.generateRandomColor());
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteHolder holder, final int i) {
        Song song = mSongList.get(i);
        holder.tvName.setText(song.name);
        holder.tbFavorite.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                buttonView.startAnimation(mScaleAnimation);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSongList.size();
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

        @BindView(R.id.tvName)
        TextView tvName;

        public FavoriteHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
