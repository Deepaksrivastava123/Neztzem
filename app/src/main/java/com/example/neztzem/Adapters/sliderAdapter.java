package com.example.neztzem.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.neztzem.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;



public class sliderAdapter extends SliderViewAdapter<sliderAdapter.sliderViewHolder> {

    private Integer[] images = {R.drawable.bannerimg1,R.drawable.bannerimg2,R.drawable.bannerimg3};


//    public sliderAdapter(Context context, ArrayList<Integer> sliderDataList) {
//        this.context = context;
//        this.mSliderItems = sliderDataList;
//    }

    @Override
    public sliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slideritemlayout,null);
        return new sliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(sliderViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class sliderViewHolder extends SliderViewAdapter.ViewHolder{
        private ImageView imageView;
        public sliderViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
