package com.example.appbarber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appbarber.Class.SalonNoti;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.squareup.picasso.Picasso;

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
        TextView textViewTenNhanVien,textViewTenSalon,textViewNgayDat, textViewXacNhan;
        LinearLayout lnlXacNhan;
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
            holder.textViewXacNhan = (TextView) view.findViewById(R.id.textViewXacNhan);
            holder.lnlXacNhan = (LinearLayout) view.findViewById(R.id.lnlXacNhan);
            view.setTag(holder);
        } else {
            holder =(ViewHolder) view.getTag();
        }

        SalonNoti salonNoti =listSalonNoti.get(i);
        Picasso.get().load(Constaint.URL + "storage/salon/" + salonNoti.getHinhAnh()).into(holder.imageViewHinh);
        holder.textViewTenNhanVien.setText(salonNoti.getTenSalon());
        holder.textViewTenSalon.setText(salonNoti.getDiaChi());
        holder.textViewNgayDat.setText(salonNoti.getThoiGian());
        holder.textViewXacNhan.setText(salonNoti.getTrangThai());

        if (salonNoti.getTrangThai().equals("Chưa xác nhận")){
            holder.lnlXacNhan.setBackgroundResource(R.drawable.border_orange);
        }
        if (salonNoti.getTrangThai().equals("đã xác nhận")){
            holder.lnlXacNhan.setBackgroundResource(R.drawable.border_green);
        }
        if (salonNoti.getTrangThai().equals("đã hoàn thành")){
            holder.lnlXacNhan.setBackgroundResource(R.drawable.border_blue);
        }

        return view;
    }
}
