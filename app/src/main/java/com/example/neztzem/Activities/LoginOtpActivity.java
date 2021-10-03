package com.example.neztzem.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.example.neztzem.Utils.Utils;

public class LoginOtpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_otp;
    private View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp);

        initView();
        handleClicks();
    }

    private void initView() {
        edit_otp = findViewById(R.id.edit_otp);
        progress = findViewById(R.id.progress);
    }
    private void handleClicks(){
        findViewById(R.id.button_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Utils.hideKeyboard(this);
        if (v.getId() == R.id.button_next) {
            verifyOtp();
        }
    }

    private void verifyOtp() {
        String otp = edit_otp.getText().toString().trim();

        if (otp.equalsIgnoreCase("0000")){
             startActivity(new Intent(LoginOtpActivity.this,DashboardActivity.class));
             SharedPrefUtils.getInstance(this).putBoolean(Constants.PREF_LOGGED_IN, true);
             finish();
        }else {
              showErrorDialog("Incorrect Otp");
        }
    }

    public void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.error));
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.create().show();
    }
}