package com.ether.minhphuong.ether_android.commonview;

import android.app.Activity;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by minhphuong on 5/24/18.
 */

public class ActivityManager {

    private static ActivityManager activityStack = null;
    private Stack<Activity> stack = null;

    private ActivityManager() {
        stack = new Stack<>();
    }

    public static ActivityManager getInstance() {
        if (activityStack == null) {
            activityStack = new ActivityManager();
        }
        return activityStack;
    }

    public void push(Activity activity) {
        removeIsFinishingActivity();
        stack.push(activity);
    }

    public void finishAll() {
        for (Activity activity : stack) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }

        if(stack != null) {
            stack.clear();
            stack = null;
        }

        stack = new Stack<>();
    }

    private void removeIsFinishingActivity() {
        if(stack != null && stack.size() > 0)
        {
            Iterator<Activity> itr = stack.iterator();
            while (itr.hasNext()) {
                Activity act = itr.next();
                if (act == null || act.isFinishing()) {
                    itr.remove();
                }
            }
        }
    }

}
