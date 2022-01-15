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

import com.example.appbarber.Class.Dichvu;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.activity.ChiTietDichVuActivity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class noibatDichvuAdapter extends RecyclerView.Adapter<noibatDichvuAdapter.noibatDvViewHolder> {
    ArrayList<Dichvu> listDichvus;
    private Context context;
    public noibatDichvuAdapter(Context context, ArrayList<Dichvu> listDichvus) {
        this.listDichvus = listDichvus;
        this.context = context;
    }

    @NonNull
    @Override
    public noibatDvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dvnoibat_view, parent, false);
        noibatDvViewHolder noibatDvViewHolder = new noibatDvViewHolder(view);
        return noibatDvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull noibatDvViewHolder holder, int position) {
        Dichvu dichvu = listDichvus.get(position);
        Picasso.get().load(Constaint.URL+"storage/dichvu/"+dichvu.getImage()).into(holder.imageDv);
        holder.tenDV.setText(dichvu.getTendv());
        holder.gia.setText(dichvu.getGia());
        holder.tenSalon.setText(dichvu.getTensalon());
        holder.dvnoibatrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ChiTietDichVuActivity.class);
                intent.putExtra("id_dichvu", dichvu.getId_dichvu());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDichvus.size();
    }

    public static class noibatDvViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView imageDv;
        TextView tenDV, gia, tenSalon;
        RelativeLayout dvnoibatrelative;
        public noibatDvViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDv = itemView.findViewById(R.id.dvnoibatimage);
            tenDV = itemView.findViewById(R.id.namedichvu);
            gia = itemView.findViewById(R.id.giadichvu);
            tenSalon = itemView.findViewById(R.id.tensalon);
            dvnoibatrelative = itemView.findViewById(R.id.dvnoibatrelative);

        }
    }
}
