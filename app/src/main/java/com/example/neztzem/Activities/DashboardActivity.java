package com.example.neztzem.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.Model.LocalDataModel.LocalDataModel;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.google.gson.Gson;

public class DashboardActivity extends AppCompatActivity {

    TextView text_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initView();
        setdata();
    }

    private void initView() {
        text_username = findViewById(R.id.text_username);
    }

    private void setdata() {
        String tempString = SharedPrefUtils.getInstance(this).getString(Constants.PREF_LOCAL_MODEL, "");
        LocalDataModel localDataModel = new Gson().fromJson(tempString, LocalDataModel.class);

        text_username.setText("Hi "+localDataModel.getFirstName());
    }
}