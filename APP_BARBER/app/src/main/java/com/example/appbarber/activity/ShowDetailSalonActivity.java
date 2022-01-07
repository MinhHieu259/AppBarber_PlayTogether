package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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

import java.util.HashMap;
import java.util.Map;

public class ShowDetailSalonActivity extends AppCompatActivity {
TextView nameSalon, diachi, name2, txtSoNam, txtSoCho;
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
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.GET_SALON_BY_ID, response -> {
            try {
                    JSONObject object = new JSONObject(response);
                    if (object.getBoolean("success")) {
                        JSONArray array = new JSONArray(object.getString("salon"));

                        JSONObject salonObject = array.getJSONObject(0);
                        Picasso.get().load(Constaint.URL + "storage/salon/" + salonObject.getString("hinhanh")).into(image);
                        nameSalon.setText(salonObject.getString("tenSalon"));
                        diachi.setText(salonObject.getString("diachi"));
                        name2.setText(salonObject.getString("tenSalon"));
                        txtSoNam.setText(salonObject.getString("soNamThanhLap"));
                        txtSoCho.setText(salonObject.getString("soChoNgoi"));

                    }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
            error.printStackTrace();
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("id_salon", id_salon+"");
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(ShowDetailSalonActivity.this);
        queue.add(request);
    }


}