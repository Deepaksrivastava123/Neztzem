package com.example.neztzem.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.Model.LocalDataModel.LocalDataModel;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.example.neztzem.Utils.ValidationUtils;
import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_mobile, edit_first_name, edit_last_name, edit_email,edit_adhaar,edit_pan;
    private View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        initView();
        handleClicks();

    }

    private void initView() {
        edit_mobile = findViewById(R.id.edit_mobile_number);
        edit_first_name = findViewById(R.id.edit_first_name);
        edit_last_name = findViewById(R.id.edit_last_name);
        edit_email = findViewById(R.id.edit_email);
        edit_adhaar = findViewById(R.id.edit_adhaar_number);
        edit_pan = findViewById(R.id.edit_pan_number);
        progress = findViewById(R.id.progress);
    }
    private void handleClicks(){
        findViewById(R.id.button_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_next) {
            validateInputs();
        }
    }

    private void validateInputs() {

        if (!ValidationUtils.blankValidation(edit_first_name) ||
                !ValidationUtils.blankValidation(edit_last_name) ||
                !ValidationUtils.blankValidation(edit_mobile) ||
                 !ValidationUtils.blankValidation(edit_adhaar) ||
                  !ValidationUtils.blankValidation(edit_pan) ||
                   !ValidationUtils.blankValidation(edit_email)) {

            return;
        }
        registerUser();
    }

    private void registerUser() {

        LocalDataModel localDataModel = new LocalDataModel();

        localDataModel.setFirstName(edit_first_name.getText().toString().trim());
        localDataModel.setLastName(edit_last_name.getText().toString().trim());
        localDataModel.setMobileNumber(edit_mobile.getText().toString().trim());
        localDataModel.setAdhaarNumber(edit_adhaar.getText().toString().trim());
        localDataModel.setPanNumber(edit_pan.getText().toString().trim());
        localDataModel.setEmail(edit_email.getText().toString().trim());

        SharedPrefUtils.getInstance(this).putString(Constants.PREF_LOCAL_MODEL,new Gson().toJson(localDataModel));
        showDialog("Register Successfully");
    }

    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });
        builder.create().show();
    }
}