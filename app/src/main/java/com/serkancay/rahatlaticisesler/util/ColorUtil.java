package com.serkancay.rahatlaticisesler.util;

import java.util.Random;

/**
 * Created by S.Serkan Cay on 16.05.2019
 */

public class ColorUtil {

    public static int generateRandomColor() {
        Random random = new Random();
        int color = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return color;
    }

}

