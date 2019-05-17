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
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import com.serkancay.rahatlaticisesler.ui.favorites.FavoriteSongListAdapter.FavoriteHolder;
import com.serkancay.rahatlaticisesler.util.AnimationUtil;
import com.serkancay.rahatlaticisesler.util.ColorUtil;
import com.serkancay.rahatlaticisesler.util.L;
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

    private Callback mCallback;

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
        final Song song = mSongList.get(i);
        holder.tvName.setText(song.name);
        holder.tbPlayPause.setOnCheckedChangeListener(null);
        holder.seekBarVolume.setOnSeekBarChangeListener(null);
        if (song.mIsPlaying) {
            holder.tbPlayPause.setChecked(true);
        } else {
            holder.tbPlayPause.setChecked(false);
        }
        L.d("SeekBar init value to " + (int) (song.mVolume * 100f));
        holder.seekBarVolume.setProgress((int) (song.mVolume * 100f));
        holder.tbFavorite.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                buttonView.startAnimation(mScaleAnimation);
                if (mCallback != null) {
                    mCallback.onFavoriteClicked(song, isChecked, i);
                }
            }
        });
        holder.tbPlayPause.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if (mCallback != null) {
                    if (isChecked) {
                        song.mIsPlaying = true;
                        mCallback.onPlayClicked(song, i);
                    } else {
                        song.mIsPlaying = false;
                        mCallback.onPauseClicked(song, i);
                    }
                }
            }
        });
        holder.seekBarVolume.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser) {
                if (mCallback != null) {
                    L.d("SeekBar progress" + progress);
                    float progressToFloat = progress / 100f;
                    mCallback.onVolumeChanged(song, progressToFloat);
                }
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {

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

    public void setCallback(Callback callback) {
        mCallback = callback;
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

    public interface Callback {

        void onFavoriteClicked(Song song, boolean isChecked, int position);

        void onPlayClicked(Song song, int position);

        void onPauseClicked(Song song, int position);

        void onVolumeChanged(Song song, float volume);
    }

}
