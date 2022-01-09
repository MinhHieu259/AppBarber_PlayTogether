package com.example.appbarber.activity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.R;
import com.example.appbarber.adapter.NhanVienSpinnerAdapter;

import java.util.ArrayList;

public class XacNhanActivity extends AppCompatActivity {
private ArrayList nhanVienLists;
private NhanVienSpinnerAdapter nhanVienSpinnerAdapter;
private Spinner spinnerNhanVien;
TextView ngayDat;
TextView gio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan);
        initNhanVienList();
        spinnerNhanVien = findViewById(R.id.spinnerNhanVien);
        nhanVienSpinnerAdapter = new NhanVienSpinnerAdapter(this, nhanVienLists);
        spinnerNhanVien.setAdapter(nhanVienSpinnerAdapter);
        ngayDat = findViewById(R.id.txtNgayDat);
        ngayDat.setText(getIntent().getStringExtra("ngayDat"));
        gio = findViewById(R.id.txtGio);
        gio.setText(getIntent().getStringExtra("gio"));
        TextView dvChon = findViewById(R.id.dichvuDachon);
        dvChon.setText(getIntent().getStringExtra("dichvu"));
    }

    private void initNhanVienList() {
        nhanVienLists = new ArrayList<>();
//        nhanVienLists.add(new NhanVienItemSpinner("Nguyễn Minh Hiếu", "Thợ Cắt"));
//        nhanVienLists.add(new NhanVienItemSpinner("Ngô Văn Thuần", "Thợ Cắt"));
    }
}