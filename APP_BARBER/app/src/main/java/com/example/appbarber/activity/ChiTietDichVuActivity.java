package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChiTietDichVuActivity extends AppCompatActivity {
    private ImageView imageCTDV;
    private ImageButton imageButtonBackCTDV;
    private TextView txtTenCTDV, txtGiaCTDV, txtTimeCTDV;
    private Button btn_ChonDV;
    private int id_dichvu = 0;
    private int id_salon = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dich_vu);
        id_dichvu = getIntent().getIntExtra("id_dichvu", 0);
        imageCTDV = findViewById(R.id.imageCTDV);
        imageButtonBackCTDV = findViewById(R.id.btb_back_CTDV);
        imageButtonBackCTDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChiTietDichVuActivity.this, DashboardActivity.class));
            }
        });

        txtTenCTDV = findViewById(R.id.txtTenCTDV);
        txtGiaCTDV = findViewById(R.id.txtGiaCTDV);
        txtTimeCTDV = findViewById(R.id.txtTimeDV);
        btn_ChonDV = findViewById(R.id.btn_ChonDV);

        getInFoCTDV();
        btn_ChonDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(ChiTietDichVuActivity.this, DatLichDVActivity.class);
                intent.putExtra("id_dichvu", id_dichvu);
                intent.putExtra("id_salon", id_salon);
                intent.putExtra("tenDV", txtTenCTDV.getText());
                startActivity(intent);
            }
        });

    }

    private void getInFoCTDV() {
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.GET_INFO_CTDV+"/"+id_dichvu, res->{

            try {

                JSONObject object = new JSONObject(res);
                if (object.getBoolean("success")) {
                    JSONArray array = new JSONArray(object.getString("dichvu"));
                    JSONObject dichvuobject = array.getJSONObject(0);

                    id_salon = dichvuobject.getInt("id_salon");
                    txtTenCTDV.setText(dichvuobject.getString("tenDichvu"));
                    txtGiaCTDV.setText(dichvuobject.getString("giaTien")+" đ");
                    txtTimeCTDV.setText(dichvuobject.getString("thoiGian")+" phút");
                    Picasso.get().load(Constaint.URL + "storage/dichvu/" + dichvuobject.getString("hinhanh")).into(imageCTDV);

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