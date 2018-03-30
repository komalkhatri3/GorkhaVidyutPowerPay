package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DELL on 3/30/2018.
 */

public class SharedPreferenceManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    
    public SharedPreferenceManager(Context context)
    {
        this.context=context;
        pref=context.getSharedPreferences("first",0);
        editor = pref.edit();
    }
    public void setFirst(boolean isFirst)
    {
        editor.putBoolean("check",isFirst);
        editor.commit();

    }
    public static boolean Check()
    {
        return pref.getBoolean("check",true);
    }
}
