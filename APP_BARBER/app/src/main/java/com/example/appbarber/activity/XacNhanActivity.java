package com.example.appbarber.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Class.NhanVienItemSpinner;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.adapter.NhanVienSpinnerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class XacNhanActivity extends AppCompatActivity {
private ArrayList nhanVienLists;
private NhanVienSpinnerAdapter nhanVienSpinnerAdapter;
private Spinner spinnerNhanVien;
private int id_nhanvien = 0;
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
        spinnerNhanVien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVienItemSpinner nhanVienItemSpinner = (NhanVienItemSpinner) adapterView.getItemAtPosition(i);
                id_nhanvien = nhanVienItemSpinner.getId_nhanvien();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initNhanVienList() {
        nhanVienLists = new ArrayList<>();
//        nhanVienLists.add(new NhanVienItemSpinner("Nguyễn Minh Hiếu", "Thợ Cắt"));
//        nhanVienLists.add(new NhanVienItemSpinner("Ngô Văn Thuần", "Thợ Cắt"));
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.GET_NHANVIEN_BY_SALON+"/"+getIntent().getStringExtra("gio")+","+getIntent().getIntExtra("id_dichvu",0), response -> {

            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")){
                    JSONArray array = new JSONArray(object.getString("nhanvien"));

                    for (int i = 0; i< array.length(); i++){
                        JSONObject nhanvienObject = array.getJSONObject(i);
                        NhanVienItemSpinner nhanVienItemSpinner = new NhanVienItemSpinner();
                        nhanVienItemSpinner.setId_nhanvien(nhanvienObject.getInt("id"));
                        nhanVienItemSpinner.setTenNhanVien(nhanvienObject.getString("hoTen"));
                        nhanVienItemSpinner.setChucVu(nhanvienObject.getString("chucvu"));
                        nhanVienLists.add(nhanVienItemSpinner);

                    }
                    if (nhanVienLists.isEmpty()){
                        Toast.makeText(XacNhanActivity.this, "Không có nhân viên làm lúc "+getIntent().getStringExtra("gio"), Toast.LENGTH_SHORT).show();
                    }
                    nhanVienSpinnerAdapter = new NhanVienSpinnerAdapter(this, nhanVienLists);
                    spinnerNhanVien.setAdapter(nhanVienSpinnerAdapter);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        }){

        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}