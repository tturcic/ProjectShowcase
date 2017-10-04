package com.tt.projectshowcase.utils;

import android.util.Log;

import com.tt.projectshowcase.BuildConfig;

/**
 * @author tturcic
 *         \date 30.8.2017.
 */
public class LogUtils {

    private static final String TAG = "ProjectShowcase";

    public static void log(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void log(String msg) {
        log(TAG, msg);
    }

    public static void log(int value) {
        log(String.valueOf(value));
    }

    public static void log(float value) {
        log(String.valueOf(value));
    }

    public static void log(boolean value) {
        log(String.valueOf(value));
    }
}
