package com.example.neztzem.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.neztzem.R;

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
    }

    @Override
    public void onClick(View v) {

     if (v.getId() == R.id.button_english){

     }
     else {

     }
       startActivity(new Intent(SelectLanguageActivity.this,RegisterActivity.class));
       finish();
    }
}