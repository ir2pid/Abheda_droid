package com.noisyninja.abheda_droid.fileio;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class Store {

    private static String PREF_NAME = "Default";

    public static void set(Context context, String key, String value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void set(Context context, String key, int value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static String get(Context context, String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }

    public static int getInt(Context context, String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return prefs.getInt(key, 0);
    }
}
