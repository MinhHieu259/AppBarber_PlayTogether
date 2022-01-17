package com.example.appbarber.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Constaint;
import com.example.appbarber.SalonGoogleMap;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SalonStatic {
    private static List<SalonGoogleMap> salons = new ArrayList<>();

    public static List<SalonGoogleMap> getSalons() {
        return salons;
    }

    public static void setSalons(List<SalonGoogleMap> salons) {
        SalonStatic.salons = salons;
    }

    public static void callSalon(Context context){
        List<SalonGoogleMap> salonArray = new ArrayList<>();
        String url = Constaint.GET_SALON;
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")){
                    JSONArray array = new JSONArray(object.getString("salon"));

                    for (int i = 0; i < array.length(); i++){
                        JSONObject salonObject = array.getJSONObject(i);
                        SalonGoogleMap salon = new SalonGoogleMap();
                        salon.setId(salonObject.getInt("id"));
                        salon.setTenSalon(salonObject.getString("tenSalon"));
                        salon.setDiaChi(salonObject.getString("diaChi"));
                        salon.setHinhAnh(salonObject.getString("hinhAnh"));
                        salon.setLatitude(salonObject.getDouble("latitude"));
                        salon.setLongitude(salonObject.getDouble("longitude"));
                        salonArray.add(salon);
                    }
                }
                SalonStatic.setSalons(salonArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        }){

        };
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        queue.add(request);
    }
}
