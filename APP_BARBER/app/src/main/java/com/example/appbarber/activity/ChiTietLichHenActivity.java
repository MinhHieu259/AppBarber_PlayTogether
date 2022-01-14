package com.example.appbarber.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChiTietLichHenActivity extends AppCompatActivity {
    private SharedPreferences userPref;
    private int id_lichhen = 0;
    private CircleImageView imageSalon;
    private TextView tenSalon, trangThai, ngayDat, gio, diaChi, phiCat, dichVu;
    private Button btn_Lich;
    private LinearLayout linearTrangThaiLich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_lich_hen);
        userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        id_lichhen = getIntent().getIntExtra("id_lichhen", 0);
        imageSalon = findViewById(R.id.imageSalonlich);
        tenSalon = findViewById(R.id.txtTenSalonLich);
        trangThai = findViewById(R.id.txtTrangthaiLich);
        ngayDat = findViewById(R.id.txtNgayDatLich);
        gio = findViewById(R.id.txtGioDatLich);
        diaChi = findViewById(R.id.txtDiachiLich);
        phiCat = findViewById(R.id.txtPhiCatLich);
        dichVu = findViewById(R.id.txtDichVuLich);
        btn_Lich = findViewById(R.id.buttonLich);
        linearTrangThaiLich = findViewById(R.id.linearTrangThaiLich);

        loadDataLichHen();
    }

    private void loadDataLichHen() {
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.CHI_TIET_LICHHEN+"/"+id_lichhen, res->{

            try {

                JSONObject object = new JSONObject(res);
                if (object.getBoolean("success")) {
                    JSONArray array = new JSONArray(object.getString("lichhen"));
                    JSONObject lichhenobject = array.getJSONObject(0);
                    JSONObject salonobject = lichhenobject.getJSONObject("salon");
                    JSONObject dichvuobject = lichhenobject.getJSONObject("dichvu");

                    Picasso.get().load(Constaint.URL + "storage/salon/" + salonobject.getString("hinhAnh")).into(imageSalon);
                    tenSalon.setText(salonobject.getString("tenSalon"));
                    trangThai.setText(lichhenobject.getString("status"));
                    ngayDat.setText(lichhenobject.getString("ngayHen"));
                    gio.setText(lichhenobject.getString("thoiGian"));
                    diaChi.setText(salonobject.getString("diaChi"));
                    phiCat.setText(lichhenobject.getString("thanhTien"));
                    dichVu.setText(dichvuobject.getString("tenDichvu"));
                    if (lichhenobject.getString("status").equals("Chưa xác nhận")){
                        linearTrangThaiLich.setBackgroundResource(R.drawable.border_orange);
                        btn_Lich.setText("Hủy lịch hẹn");
                        btn_Lich.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChiTietLichHenActivity.this);
                                builder.setMessage("Hủy lịch hẹn ?");
                                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        huyLich();
                                    }
                                });
                                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                builder.show();
                            }
                        });
                    }
                    if (lichhenobject.getString("status").equals("đã xác nhận")){
                        linearTrangThaiLich.setBackgroundResource(R.drawable.border_green);
                        btn_Lich.setEnabled(false);
                        btn_Lich.setBackgroundResource(R.drawable.border_gray);
                    }

                    if (lichhenobject.getString("status").equals("đã hoàn thành")){
                        linearTrangThaiLich.setBackgroundResource(R.drawable.border_blue);
                        btn_Lich.setText("Đánh giá dịch vụ");
                    }



                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = userPref.getString("token", "");
                HashMap<String,String> map = new HashMap<>();
                map.put("Authorization","Bearer "+token);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    private void huyLich() {
        StringRequest request = new StringRequest(Request.Method.POST, Constaint.HUY_LICH_HEN+"/"+id_lichhen, res->{
            try {
                JSONObject object = new JSONObject(res);
                if (object.getBoolean("success")){
                    Intent intent = new  Intent(ChiTietLichHenActivity.this, DashboardActivity.class);
                    intent.putExtra("message",1);
                    startActivity(intent);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = userPref.getString("token", "");
                HashMap<String,String> map = new HashMap<>();
                map.put("Authorization","Bearer "+token);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}