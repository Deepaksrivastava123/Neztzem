package com.example.neztzem.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.neztzem.Constants.Constants;

public class SharedPrefUtils {


    private SharedPreferences preferences = null;

    private static SharedPrefUtils instance = null;

    private SharedPrefUtils(Context context) {
        preferences = context.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefUtils(context);
        }
        return instance;
    }

    public  void putString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public void resetAll() {
        preferences.edit().clear().apply();
    }
}
