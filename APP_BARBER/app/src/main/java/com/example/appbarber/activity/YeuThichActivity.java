package com.example.appbarber.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbarber.Class.YeuThich;
import com.example.appbarber.R;
import com.example.appbarber.adapter.YeuThichAdapter;

import java.util.ArrayList;
import java.util.List;

public class YeuThichActivity extends AppCompatActivity {
private RecyclerView yeuThichRecycler;
private List<YeuThich> yeuThichList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);

        yeuThichRecycler = findViewById(R.id.recyclerYeuThich);

        yeuThichList = new ArrayList<>();
        yeuThichList.add(new YeuThich("Salon Lộc", R.drawable.salonloc));
        yeuThichList.add(new YeuThich("Salon 30shine", R.drawable.naubarber));
        yeuThichList.add(new YeuThich("nâi Lộc", R.drawable.salonloc));
        yeuThichList.add(new YeuThich("a Lộc", R.drawable.salonloc));

        YeuThichAdapter yeuThichAdapter = new YeuThichAdapter(this, yeuThichList);
        yeuThichRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        yeuThichRecycler.setAdapter(yeuThichAdapter);
    }
}