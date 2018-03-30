package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DELL on 3/30/2018.
 */

public class SharedPreferenceManager {

    public static final String SHARED_PREF = "shared_pref";

    //Key
    public static final String isWalkThroughDone = "isWalkThroughDone";


    private SharedPreferences mPref;

    private static SharedPreferenceManager sInstance;

    public static SharedPreferenceManager getInstance(Context context){
        if(sInstance == null){
            sInstance = new SharedPreferenceManager(context);
        }

        return sInstance;
    }

    public SharedPreferenceManager(Context context)
    {
        mPref=context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
    }
    public void setBoolean(String key,boolean bool)
    {
        mPref.edit().putBoolean(key,bool).apply();
    }

    public boolean getBoolean(String key)
    {
        return mPref.getBoolean(key,false);
    }

    public void setString(String key, String str)
    {
        mPref.edit().putString(key,str).apply();
    }
    public String getString(String key)
    {
        return mPref.getString(key,"");
    }
}
