package com.serkancay.rahatlaticisesler.manager;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.serkancay.rahatlaticisesler.data.db.entity.Song;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.Serkan Cay on 17.05.2019
 */

public class SoundManager {

    private SoundPool mSoundPool;

    private Context mContext;

    private List<Song> mLoadedSongs;

    public SoundManager(Context context, int maxStreams) {
        mContext = context;
        mSoundPool = new SoundPool(maxStreams, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(mOnLoadCompleteListener);
        mLoadedSongs = new ArrayList<>();
    }

    public void playSong(Song song) {
        int index = isSongAlreadyExists(song);
        if (index == -1) {
            mLoadedSongs.add(song);
            loadSound(song);
        } else {
            mSoundPool.resume(mLoadedSongs.get(index).mPoolId);
        }
    }

    public void pauseSong(Song song) {
        int index = isSongAlreadyExists(song);
        if (index != -1) {
            mSoundPool.pause(mLoadedSongs.get(index).mPoolId);
        }
    }

    /**
     * @param volume value (range = 0.0 to 1.0)
     */
    public void setVolume(Song song, float volume) {
        int index = isSongAlreadyExists(song);
        if (index != -1) {
            mSoundPool.setVolume(mLoadedSongs.get(index).mPoolId, volume, volume);
        }
    }

    public void unloadSong(Song song) {
        int index = isSongAlreadyExists(song);
        if (index != -1) {
            int poolId = mLoadedSongs.get(index).mPoolId;
            mSoundPool.stop(poolId);
            mSoundPool.unload(poolId);
            mLoadedSongs.remove(index);
        }
    }

    private int loadSound(Song song) {
        Resources res = mContext.getResources();
        int resId = res.getIdentifier(song.song_path, "raw", mContext.getPackageName());
        int poolId = mSoundPool.load(mContext, resId, 1);
        return poolId;
    }

    private int isSongAlreadyExists(Song song) {
        int index = -1;
        for (int i = 0; i < mLoadedSongs.size(); i++) {
            Song loadedSong = mLoadedSongs.get(i);
            if (song.id == loadedSong.id) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void playSound(Song song) {
        mSoundPool.play(song.mPoolId, 1, 1, 1, -1, 1f);
    }

    private OnLoadCompleteListener mOnLoadCompleteListener = new OnLoadCompleteListener() {
        @Override
        public void onLoadComplete(final SoundPool soundPool, final int sampleId, final int status) {
            if (status == 0) {
                if (mLoadedSongs.size() > 0) {
                    mLoadedSongs.get(mLoadedSongs.size() - 1).mPoolId = sampleId;
                    playSound(mLoadedSongs.get(mLoadedSongs.size() - 1));
                }
            } else {
                if (mLoadedSongs.size() > 0) {
                    mLoadedSongs.remove(mLoadedSongs.size() - 1);
                }
            }
        }
    };

}
