package com.serkancay.rahatlaticisesler.ui.library.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.serkancay.rahatlaticisesler.R;
import com.serkancay.rahatlaticisesler.data.network.model.SongListResponse.Song;
import com.serkancay.rahatlaticisesler.ui.library.detail.SongListAdapter.SongHolder;
import com.serkancay.rahatlaticisesler.util.AnimationUtil;
import com.serkancay.rahatlaticisesler.util.ColorUtil;
import java.util.List;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class SongListAdapter extends Adapter<SongHolder> {

    private static final int RESOURCE = R.layout.item_category_detail_list;

    private List<Song> mSongList;

    private LayoutInflater mInflater;

    private LinearLayoutManager mLayoutManager;

    private DividerItemDecoration mItemDecoration;

    private Context mContext;

    private ScaleAnimation mScaleAnimation;

    public SongListAdapter(Context context, List<Song> songList) {
        mSongList = songList;
        mInflater = LayoutInflater.from(context);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        mContext = context;
        mScaleAnimation = AnimationUtil.createScaleAnimation(500);
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View item = mInflater.inflate(RESOURCE, viewGroup, false);
        SongHolder holder = new SongHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SongHolder songHolder, final int i) {
        Song song = mSongList.get(i);
        songHolder.tvName.setText(song.getName());
        songHolder.view.setBackgroundColor(ColorUtil.generateRandomColor());
        songHolder.tbFavorite.setOnCheckedChangeListener(new OnCheckedChangeListener() {
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

    public static class SongHolder extends ViewHolder {

        @BindView(R.id.tbFavorite)
        ToggleButton tbFavorite;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.view)
        View view;

        SongHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}