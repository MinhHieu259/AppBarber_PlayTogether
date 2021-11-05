package com.example.appbarber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbarber.Class.Salon;
import com.example.appbarber.Class.SalonNoti;
import com.example.appbarber.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SaLonNotiAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SalonNoti> listSalonNoti;

    public SaLonNotiAdapter(Context context, int layout, List<SalonNoti> listSalonNoti){
        this.context = context;
        this.layout = layout;
        this.listSalonNoti = listSalonNoti;
    }


    @Override
    public int getCount() {
        if(listSalonNoti != null){
            return listSalonNoti.size();
        }
        return 0;
    }
    private class ViewHolder{
        CircleImageView imageViewHinh;
        TextView textViewTenNhanVien,textViewTenSalon,textViewNgayDat;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.imageViewHinh = (CircleImageView) view.findViewById(R.id.imageViewHinh);
            holder.textViewTenNhanVien = (TextView) view.findViewById(R.id.textViewTenNhanVien);
            holder.textViewTenSalon = (TextView) view.findViewById(R.id.textViewTenSalon);
            holder.textViewNgayDat = (TextView) view.findViewById(R.id.textViewNgayDat);
            view.setTag(holder);
        } else {
            holder =(ViewHolder) view.getTag();
        }

        SalonNoti salonNoti =listSalonNoti.get(i);
        holder.imageViewHinh.setImageResource(salonNoti.getHinhAnh());
        holder.textViewTenNhanVien.setText(salonNoti.getNhanVienCatToc());
        holder.textViewTenSalon.setText(salonNoti.getTenSalon());
        holder.textViewNgayDat.setText(salonNoti.getThoiGian());
        return view;
    }
}
