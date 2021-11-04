package com.example.appbarber.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.Class.SalonhelperClasss;
import com.example.appbarber.R;

import java.util.ArrayList;

public class noibatSalonAdapter extends RecyclerView.Adapter<noibatSalonAdapter.noibatViewHolder> {
    ArrayList<SalonhelperClasss> noibatSalons;

    public noibatSalonAdapter(ArrayList<SalonhelperClasss> noibatSalons) {
        this.noibatSalons = noibatSalons;
    }

    @NonNull
    @Override
    public noibatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noibat_view_design, parent, false);
        noibatViewHolder noibatViewHolder = new noibatViewHolder(view);
        return noibatViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull noibatViewHolder holder, int position) {
     SalonhelperClasss salonhelperClasss = noibatSalons.get(position);
     holder.image.setImageResource(salonhelperClasss.getImage());
     holder.title.setText(salonhelperClasss.getTitle());
     holder.address.setText(salonhelperClasss.getAddress());
    }

    @Override
    public int getItemCount() {
        return noibatSalons.size();
    }

    public static class noibatViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, address;

        public noibatViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.noibatimage);
            title = itemView.findViewById(R.id.namesalon);
            address = itemView.findViewById(R.id.diachisalon);

        }
    }
}
