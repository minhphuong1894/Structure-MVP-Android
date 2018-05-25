package com.ether.minhphuong.ether_android.utils;

import android.app.Activity;

import com.ether.minhphuong.ether_android.R;

/**
 * Created by minhphuong on 5/23/18.
 */

public class Utils {

    public static boolean isStringNull(String text) {
        return text == null || text.equals("");
    }

    public static void slideRightToLeft(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void slideLeftToRight(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
    }

}
