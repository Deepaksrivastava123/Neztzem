package com.example.neztzem.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.Model.LocalDataModel.LocalDataModel;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.example.neztzem.Utils.Utils;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_mobile;
    private View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        handleClicks();
    }

    private void initView() {
        edit_mobile = findViewById(R.id.edit_mobile_number);
        progress = findViewById(R.id.progress);
    }
    private void handleClicks(){
        findViewById(R.id.button_next).setOnClickListener(this);
        findViewById(R.id.text_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Utils.hideKeyboard(this);
        if (v.getId() == R.id.button_next) {
            sendOtp();
        } else if (v.getId() == R.id.text_register) {
            moveToRegisterScreen();
        }
    }

    private void sendOtp() {
        String mobileNo = edit_mobile.getText().toString();

        if (mobileNo.isEmpty() || mobileNo.length() < 10) {
            edit_mobile.setText("");
            showErrorDialog(getString(R.string.error_valid_mobile_number));
            return;
        }
        else {
            handleMobileNo(mobileNo);
        }

    }

    private void handleMobileNo(String mobileNo) {
        String tempString = SharedPrefUtils.getInstance(this).getString(Constants.PREF_LOCAL_MODEL, "");
        LocalDataModel localDataModel = new Gson().fromJson(tempString, LocalDataModel.class);

        if (localDataModel == null){
            showErrorDialog(getString(R.string.not_register));
        }
        else {
         if (localDataModel.getMobileNumber().equalsIgnoreCase(mobileNo)){
            moveToOtpScreen();
          }
         else {
            showErrorDialog(getString(R.string.not_register));
         }
        }
    }

    private void moveToOtpScreen() {
        startActivity(new Intent(LoginActivity.this,LoginOtpActivity.class));
    }


    private void moveToRegisterScreen() {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

    public void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.error));
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.create().show();
    }
}