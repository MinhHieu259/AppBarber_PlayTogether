package com.example.appbarber.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Class.Salon;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.adapter.TimKiemAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimKiemActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTK;
    private TimKiemAdapter timKiemAdapter;
    private ArrayList<Salon> salons;
    private Toolbar toolBar;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        recyclerViewTK = findViewById(R.id.recycleTimkiem);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewTK.setLayoutManager(linearLayoutManager);
        toolBar = findViewById(R.id.toolbarTK);
        this.setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getListSalon();

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewTK.addItemDecoration(itemDecoration);
    }

    private void  getListSalon() {
         salons = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.POST, Constaint.GET_SALON, response -> {

            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")){
                    JSONArray array = new JSONArray(object.getString("salon"));
                    for (int i = 0; i< array.length(); i++){
                        JSONObject salonObject = array.getJSONObject(i);
                        Salon salon = new Salon();
                        salon.setId(salonObject.getInt("id"));
                        salon.setName(salonObject.getString("tenSalon"));
                        salon.setAddress(salonObject.getString("diaChi"));
                        salon.setImage(salonObject.getString("hinhAnh"));
                        salon.setRating(salonObject.getInt("rating"));
                        salons.add(salon);

                    }
                    recyclerViewTK.setAdapter(new TimKiemAdapter(salons));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timkiem, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                timKiemAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                timKiemAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()){
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}