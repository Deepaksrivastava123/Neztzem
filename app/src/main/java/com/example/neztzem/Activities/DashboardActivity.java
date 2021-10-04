package com.example.neztzem.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neztzem.Constants.Constants;
import com.example.neztzem.Model.LocalDataModel.LocalDataModel;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.google.gson.Gson;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

public class DashboardActivity extends AppCompatActivity implements PaymentResultListener {

    TextView text_username,text_logout;
    Button btPay;
    String sAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sAmount = "100";

        //Connect and round off
        int amount = Math.round(Float.parseFloat(sAmount)*100);
        initView();
        handleClick();
        setdata();
    }

    private void initView() {
        text_username = findViewById(R.id.text_username);
        text_logout = findViewById(R.id.text_logout);
        btPay = findViewById(R.id.bt_pay);
    }

    private void setdata() {
        String tempString = SharedPrefUtils.getInstance(this).getString(Constants.PREF_LOCAL_MODEL, "");
        LocalDataModel localDataModel = new Gson().fromJson(tempString, LocalDataModel.class);

        text_username.setText("Hi "+localDataModel.getFirstName());
    }

    private void handleClick(){
       text_logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               logout();
           }
       });
       btPay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               initiateTransaction();
           }
       });

    }

    private void initiateTransaction() {

        //Initialize razorpay checkout
        Checkout checkout = new Checkout();

        //Set Key id
        checkout.setKeyID("rzp_test_m98twl3Wq4Sm2L");

        //Set image
        checkout.setImage(R.drawable.pay4);

        //initiliaze json object
        JSONObject object = new JSONObject();


        try {
            //Put Name
            object.put("name","NetZamPay");

            // Put Description
            object.put("description","Test Payment");

            //put theme color
            object.put("theme.color","#0093DD");

            //Put currency unit
            object.put("currency", "INR");

            //Put amount
            object.put("amount", sAmount);

            //Putmobile number
            object.put("prefill.contact", "8318919787");

            //Putemail
            object.put("prefill.email", "tarunshrm768@gmail.com");

            //open razorpay checkout
            checkout.open(DashboardActivity.this,object);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void logout() {
        SharedPrefUtils.getInstance(this).resetAll();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onPaymentSuccess(String s) {

        //Initialise alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Set title
        builder.setTitle("Payment ID");

        //Set Message
        builder.setMessage(s);

        //show alert dialogue
        builder.show();

    }

    @Override
    public void onPaymentError(int i, String s) {


        //Display Toast
        Toast.makeText(getApplicationContext(), "s", Toast.LENGTH_SHORT).show();
    }
}