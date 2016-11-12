package com.example.xyzreader.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by Sagar Rathod on 12-Nov-2016.
 */

public class Util {

    private static final String LOG_TAG = Util.class.getSimpleName();

    public static boolean isNetworkAvailable(Context context){
        boolean flag = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null) {
            flag = ni.isConnected();
        }

        Log.d(LOG_TAG,"No network available:" + flag);

        return flag;
    }
}
