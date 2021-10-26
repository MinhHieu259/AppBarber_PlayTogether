package com.example.appbarber.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.Class.Salon;
import com.example.appbarber.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHolder> {

    private final List<Salon> salons;

    public SalonAdapter(List<Salon> salons) {
        this.salons = salons;
    }

    @NonNull
    @Override
    public SalonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SalonViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_slider_home,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SalonViewHolder holder, int position) {
    holder.setSalon(salons.get(position));
    }

    @Override
    public int getItemCount() {
        return salons.size();
    }

    static class SalonViewHolder extends RecyclerView.ViewHolder{
        private final RoundedImageView imagePoster;
        private final TextView txtName, txtAddress;
        private final RatingBar ratingBar;
        public SalonViewHolder(View view){
            super(view);
            imagePoster = view.findViewById(R.id.imagePoster);
            txtAddress = view.findViewById(R.id.textaddress);
            txtName = view.findViewById(R.id.textname);
            ratingBar = view.findViewById(R.id.ratingBar);
        }
        void setSalon(Salon salon){
            imagePoster.setImageResource(salon.image);
            txtAddress.setText(salon.address);
            txtName.setText(salon.name);
            ratingBar.setRating(salon.rating);
        }
    }
}
