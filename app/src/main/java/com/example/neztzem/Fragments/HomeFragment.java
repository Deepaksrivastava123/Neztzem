package com.example.neztzem.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neztzem.Activities.MainActivity;
import com.example.neztzem.Adapters.sliderAdapter;
import com.example.neztzem.Constants.Constants;
import com.example.neztzem.Model.LocalDataModel.LocalDataModel;
import com.example.neztzem.R;
import com.example.neztzem.Utils.SharedPrefUtils;
import com.google.gson.Gson;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    TextView text_username;
    SliderView sliderView;
    sliderAdapter adapter;
    ImageView imageLogout;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);
        //setBannnerData();
        setImageSlider();
        setDataToViews();
        handleClicks();
        return view;

    }

    private void handleClicks() {
        imageLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        SharedPrefUtils.getInstance(getActivity()).resetAll();
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    private void setDataToViews() {
        String tempString = SharedPrefUtils.getInstance(getActivity()).getString(Constants.PREF_LOCAL_MODEL, "");
        LocalDataModel localDataModel = new Gson().fromJson(tempString, LocalDataModel.class);
        text_username.setText("Hi "+localDataModel.getFirstName());
    }

    private void setImageSlider() {

        adapter=new sliderAdapter();
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

//    private void setBannnerData() {
//        sliderDataList.add(R.drawable.bannerimg1);
//        sliderDataList.add(R.drawable.bannerimg2);
//        sliderDataList.add(R.drawable.bannerimg3);
//    }

    private void initViews(View view) {
        sliderView = view.findViewById(R.id.slider_View);
        text_username = view.findViewById(R.id.txt_username);
        imageLogout = view.findViewById(R.id.img_Logout);
    }
}