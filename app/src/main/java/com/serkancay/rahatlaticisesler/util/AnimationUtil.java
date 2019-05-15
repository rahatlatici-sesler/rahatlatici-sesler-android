package com.serkancay.rahatlaticisesler.util;

import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class AnimationUtil {

    /**
     * Buyuyup-kuculme animasyonu olusturur.
     */
    public static Animation createScaleAnimation(long duration) {
        ScaleAnimation scaleAnimation;
        BounceInterpolator bounceInterpolator;
        scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.7f,
                Animation.RELATIVE_TO_SELF, 0.7f);
        scaleAnimation.setDuration(duration);
        bounceInterpolator = new BounceInterpolator();
        scaleAnimation.setInterpolator(bounceInterpolator);
        return scaleAnimation;
    }

}
