package com.example.neztzem.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;

import java.util.Locale;

public class SelectLanguageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        handleClicks();
    }

    private void handleClicks() {
        findViewById(R.id.button_english).setOnClickListener(this);
        findViewById(R.id.button_hindi).setOnClickListener(this);
        findViewById(R.id.button_marathi).setOnClickListener(this);
        findViewById(R.id.button_gujrati).setOnClickListener(this);
        findViewById(R.id.button_tamil).setOnClickListener(this);
        findViewById(R.id.button_telgu).setOnClickListener(this);
        findViewById(R.id.button_punjabi).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setLanguage(Activity activity, String language){
        Locale locale = new Locale(language);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_english:{
              setLanguage(this,"en");
              if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                  startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                  finish();
              }else {
                  startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                  finish();
              }
              break;
            }
            case R.id.button_hindi:{
                setLanguage(this,"hi");
                if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                    startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                    finish();
                }
                break;

            }
            case R.id.button_gujrati:{
                setLanguage(this,"gu");
                if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                    startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                    finish();
                }
                break;
            }
            case R.id.button_marathi:{
                setLanguage(this,"ma");
                if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                    startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                    finish();
                }
                break;
            }
            case R.id.button_punjabi:{
                setLanguage(this,"pu");
                if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                    startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                    finish();
                }
                break;
            }
            case R.id.button_tamil:{

                setLanguage(this,"ta");
                if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                    startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                    finish();
                }
                break;
            } case R.id.button_telgu:{
                setLanguage(this,"te");
                if (SharedPrefUtils.getInstance(this).getBoolean(Constants.PREF_LOGGED_IN,false)) {
                    startActivity(new Intent(SelectLanguageActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                    finish();
                }
                break;
            }

        }
    }
}