package com.example.appbarber.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.R;
import com.example.appbarber.fragment.HomeFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHoder> {

    private final List<Salon> salons;

    public SalonAdapter( List<Salon> salons) {
        this.salons = salons;
    }



    @NonNull
    @Override
    public SalonViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SalonViewHoder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_slider_home,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SalonViewHoder holder, int position) {
        holder.setSalon(salons.get(position));
    }

    @Override
    public int getItemCount() {
        return salons.size();
    }

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
        void setSalon(Salon sliderSalon){
            imagePoster.setImageResource(sliderSalon.image);
            textName.setText(sliderSalon.name);
            textAddress.setText(sliderSalon.address);
            ratingBar.setRating(sliderSalon.rating);
        }
    }
}
