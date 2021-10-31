package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbarber.Class.Salon;
import com.example.appbarber.R;
import com.example.appbarber.adapter.SalonAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    LinearLayout lngantoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        lngantoi = (LinearLayout) findViewById(R.id.lngantoi);
        lngantoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Gần tôi nhất", Toast.LENGTH_SHORT).show();
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.lichhen:
                        startActivity(new Intent(getApplicationContext()
                                , CalendarActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.thongbao:
                        startActivity(new Intent(getApplicationContext()
                                , NotiActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.taikhoan:
                        startActivity(new Intent(getApplicationContext()
                                , AccountActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        setupSalonsViewPager();
    }

    private void setupSalonsViewPager(){
        ViewPager2 salonViewPager = findViewById(R.id.salonViewPager);
        salonViewPager.setClipToPadding(false);
        salonViewPager.setClipChildren(false);
        salonViewPager.setOffscreenPageLimit(3);
        salonViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        salonViewPager.setPageTransformer(compositePageTransformer);
        salonViewPager.setAdapter(new SalonAdapter(getSalons()));
    }

    private List<Salon> getSalons(){
        List<Salon> salons = new ArrayList<>();
        Salon s30shine = new Salon();
        s30shine.name = "30Shine tiệm cắt tóc chuyên nghiệp";
        s30shine.address = "40 Cao Thắng, Hải Châu, Đà Nẵng";
        s30shine.image = R.drawable.image30shine;
        s30shine.rating = 4.6f;
        salons.add(s30shine);


        Salon salonloc = new Salon();
        salonloc.name = "Salon Lộc";
        salonloc.address = "40 Trưng Nữ Vương";
        salonloc.image = R.drawable.salonloc;
        salonloc.rating = 4.2f;
        salons.add(salonloc);

        return salons;
    }
}