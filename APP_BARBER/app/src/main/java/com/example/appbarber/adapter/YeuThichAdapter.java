package com.example.appbarber.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.Class.YeuThich;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.activity.ShowDetailSalonActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichAdapter.MyViewHolder> {

    private Context context;
    private List<YeuThich> yeuThichList;

    public YeuThichAdapter(Context context, List<YeuThich> yeuThichList) {
        this.context = context;
        this.yeuThichList = yeuThichList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview_item_yeuthich, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtTenSalon.setText(yeuThichList.get(position).getTenSalon());
        Picasso.get().load(Constaint.URL + "storage/salon/" + yeuThichList.get(position).getImageSalon()).into(holder.imageYeuThich);
        holder.layoutYeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailSalonActivity.class);
                intent.putExtra("salonId", yeuThichList.get(position).getId_salon());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return yeuThichList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageYeuThich;
        TextView txtTenSalon;
        LinearLayout layoutYeuThich;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageYeuThich = (ImageView) itemView.findViewById(R.id.imageSalonYeuThich);
            txtTenSalon = (TextView) itemView.findViewById(R.id.tenSalonYeuThich);
            layoutYeuThich = (LinearLayout) itemView.findViewById(R.id.linearYeuThich);
        }
    }
}
