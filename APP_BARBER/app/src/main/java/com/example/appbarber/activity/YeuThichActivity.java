package com.example.appbarber.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Class.YeuThich;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.adapter.YeuThichAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YeuThichActivity extends AppCompatActivity {
private RecyclerView yeuThichRecycler;
private List<YeuThich> yeuThichList;
    private SharedPreferences userPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);
        userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        yeuThichRecycler = findViewById(R.id.recyclerYeuThich);

        yeuThichList = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.GET_LIST_YEUTHICH, response -> {

            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")){
                    JSONArray array = new JSONArray(object.getString("yeuthich"));
                    for (int i = 0; i< array.length(); i++){
                        JSONObject yeuthichObject = array.getJSONObject(i);
                        JSONObject salonObject = yeuthichObject.getJSONObject("salon");
                        YeuThich yeuThich = new YeuThich();
                        yeuThich.setId_salon(salonObject.getInt("id"));
                        yeuThich.setImageSalon(salonObject.getString("hinhAnh"));
                        yeuThich.setTenSalon(salonObject.getString("tenSalon"));
                        yeuThichList.add(yeuThich);

                    }
                    yeuThichRecycler.setLayoutManager(new GridLayoutManager(this, 3));
                    yeuThichRecycler.setAdapter(new YeuThichAdapter(this, yeuThichList));

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