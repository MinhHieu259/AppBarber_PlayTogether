package com.example.appbarber.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.Class.SalonhelperFeature;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.activity.ShowDetailSalonActivity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class noibatSalonAdapter extends RecyclerView.Adapter<noibatSalonAdapter.noibatViewHolder> {
    ArrayList<SalonhelperFeature> noibatSalons;
    private Context context;
    public noibatSalonAdapter(Context context, ArrayList<SalonhelperFeature> noibatSalons) {
        this.noibatSalons = noibatSalons;
        this.context = context;
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
     SalonhelperFeature salonhelperClasss = noibatSalons.get(position);
     Picasso.get().load(Constaint.URL+"storage/salon/"+salonhelperClasss.getImage()).into(holder.image);
     holder.title.setText(salonhelperClasss.getTitle());
     holder.address.setText(salonhelperClasss.getAddress());
     holder.noibatrelative.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(holder.itemView.getContext(), ShowDetailSalonActivity.class);
             intent.putExtra("salonId", salonhelperClasss.getId_salon());
             holder.itemView.getContext().startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return noibatSalons.size();
    }

    public static class noibatViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView image;
        TextView title, address;
        RelativeLayout noibatrelative;

        public noibatViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.noibatimage);
            title = itemView.findViewById(R.id.namesalon);
            address = itemView.findViewById(R.id.diachisalon);
            noibatrelative = itemView.findViewById(R.id.noibatrelative);
        }
    }
}
