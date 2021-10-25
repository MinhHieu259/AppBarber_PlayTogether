package com.example.appbarber.Class;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderSalonAdapter extends RecyclerView.Adapter<SliderSalonAdapter.SalonViewHoder> {
    private final List<SliderSalonAdapter>
    static class SalonViewHoder extends RecyclerView.ViewHolder{
        private final RoundedImageView imagePoster;
        private final TextView textName, textAddress;
        private final RatingBar ratingBar;
        public SalonViewHoder(View view){
            super(view);
            imagePoster = view.findViewById(R.id.imagePoster);
            textName = view.findViewById(R.id.textname);
            textAddress = view.findViewById(R.id.textaddress);
            ratingBar = view.findViewById(R.id.ratingBar);
        }
        void setSalon(SliderSalon sliderSalon){
            imagePoster.setImageResource(sliderSalon.image);
            textName.setText(sliderSalon.name);
            textAddress.setText(sliderSalon.address);
            ratingBar.setRating(sliderSalon.rating);
        }
    }
}
