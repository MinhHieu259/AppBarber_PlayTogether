package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowDetailSalonActivity extends AppCompatActivity {
TextView nameSalon, diachi, name2, txtSoNam, txtSoCho, txtChuTiem, txtGioiThieu;
RoundedImageView image;
Button btnDatLich;
private int id_salon = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_detail_salon);
        nameSalon = findViewById(R.id.ten_detail_salon);
        name2 = findViewById(R.id.txtTensalon);
        diachi = findViewById(R.id.txtDiachi);
        txtSoCho = findViewById(R.id.txtSoCho);
        txtSoNam = findViewById(R.id.txtSoNam);
        txtChuTiem = findViewById(R.id.txtTenChutiem);
        txtGioiThieu = findViewById(R.id.txtGioithieu);
        image = findViewById(R.id.image_detail_salon);
        btnDatLich = findViewById(R.id.btn_datlich);
        id_salon = getIntent().getIntExtra("salonId", 0);

        getInFoSalon();

        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailSalonActivity.this, DatLichActivity.class);
                startActivity(intent);
            }
        });
    }
    public void getInFoSalon(){
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.GET_SALON_BY_ID+"/"+id_salon, res->{

            try {
                JSONObject object = new JSONObject(res);
                if (object.getBoolean("success")){
                    JSONArray salonarray = new JSONArray(object.getString("salon"));
                    JSONObject salonobject = salonarray.getJSONObject(0);
                    String namesalon = salonobject.getString("tenSalon");
                    String name2salon = salonobject.getString("tenSalon");
                    String diaChi = salonobject.getString("diachi");
                    String soCho = salonobject.getString("soChoNgoi");
                    String soNam = salonobject.getString("soNamThanhLap");
                    String imageSalon = salonobject.getString("hinhanh");
                    String chuTiem = salonobject.getString("chuTiem");
                    String gioiThieu = salonobject.getString("gioiThieu");
                    nameSalon.setText(namesalon);
                    name2.setText(name2salon);
                    diachi.setText(diaChi);
                    txtSoCho.setText(soCho);
                    txtSoNam.setText(soNam);
                    txtChuTiem.setText(chuTiem);
                    txtGioiThieu.setText(gioiThieu);
                    Picasso.get().load(Constaint.URL+"storage/salon/"+imageSalon).into(image);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String,String> map = new HashMap<>();
//                map.put("id_salon", id_salon+"");
//                return map;
//            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }


}