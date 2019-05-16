package com.serkancay.rahatlaticisesler.helper;

import android.content.Context;
import android.support.v4.widget.CircularProgressDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.serkancay.rahatlaticisesler.R;
import com.squareup.picasso.Picasso;

public class PicassoHelper {

    private Picasso mPicasso;

    private Context mContext;

    private int mPlaceHolderResId = R.drawable.img_palm_logo;

    public PicassoHelper(Context context) {
        mPicasso = Picasso.get();
        mContext = context;
    }

    public void load(ImageView imageView, String url) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();
        if (TextUtils.isEmpty(url)) {
            imageView.setImageResource(mPlaceHolderResId);
        } else {
            mPicasso.load(url).placeholder(circularProgressDrawable).error(mPlaceHolderResId).into(imageView);
        }
    }

    public void load(ImageView imageView, String url, int placeHolderResId) {
        mPlaceHolderResId = placeHolderResId;
        load(imageView, url);
    }

}
