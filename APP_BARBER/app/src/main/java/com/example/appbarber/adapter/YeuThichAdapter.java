package com.example.appbarber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.Class.YeuThich;
import com.example.appbarber.R;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtTenSalon.setText(yeuThichList.get(position).getTenSalon());
        holder.imageYeuThich.setImageResource(yeuThichList.get(position).getImageSalon());

    }

    @Override
    public int getItemCount() {
        return yeuThichList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageYeuThich;
        TextView txtTenSalon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageYeuThich = (ImageView) itemView.findViewById(R.id.imageSalonYeuThich);
            txtTenSalon = (TextView) itemView.findViewById(R.id.tenSalonYeuThich);
        }
    }
}
