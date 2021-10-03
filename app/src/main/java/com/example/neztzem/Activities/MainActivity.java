package com.example.neztzem.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;

public class MainActivity extends AppCompatActivity {
    static String TAG = "SplashActivity";
    private boolean IS_ALIVE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        IS_ALIVE = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                moveToNextActivity();
            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IS_ALIVE = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        IS_ALIVE = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        IS_ALIVE = false;
    }

    private void moveToNextActivity() {
        if (IS_ALIVE) {
            IS_ALIVE = false;
              startActivity(new Intent(MainActivity.this,SelectLanguageActivity.class));
              finish();
            }

        }
    }


