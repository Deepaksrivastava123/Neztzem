package com.example.neztzem.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.Model.LocalDataModel.LocalDataModel;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class DashboardActivity extends AppCompatActivity {

    TextView text_username,text_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initView();
        handleClick();
        setdata();
    }

    private void initView() {
        text_username = findViewById(R.id.text_username);
        text_logout = findViewById(R.id.text_logout);
    }

    private void setdata() {
        String tempString = SharedPrefUtils.getInstance(this).getString(Constants.PREF_LOCAL_MODEL, "");
        LocalDataModel localDataModel = new Gson().fromJson(tempString, LocalDataModel.class);

        text_username.setText("Hi "+localDataModel.getFirstName());
    }

    private void handleClick(){
        text_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              logout();
            }
        });
    }

    private void logout() {
        SharedPrefUtils.getInstance(this).resetAll();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}