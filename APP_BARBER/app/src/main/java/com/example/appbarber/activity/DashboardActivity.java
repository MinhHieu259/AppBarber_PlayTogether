package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbarber.Class.Dichvu;
import com.example.appbarber.Class.Salon;
import com.example.appbarber.Class.SalonhelperFeature;
import com.example.appbarber.R;
import com.example.appbarber.adapter.SalonAdapter;
import com.example.appbarber.adapter.noibatDichvuAdapter;
import com.example.appbarber.adapter.noibatSalonAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    LinearLayout lngantoi, lnbando;
    RecyclerView noibatRecycler, dvnoibatRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        lngantoi = (LinearLayout) findViewById(R.id.lngantoi);
        lnbando = (LinearLayout) findViewById(R.id.lnbando);
        lnbando.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MapsActivity.class);
                startActivity(intent);
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
        noibatRecycler = findViewById(R.id.recycleNoibat);
        noibatRecycler();
        dvnoibatRecycler = findViewById(R.id.recycleDvNoiBat);
        dvNoibatRecycler();
    }

    private void noibatRecycler() {
        noibatRecycler.setHasFixedSize(true);
        noibatRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<SalonhelperFeature> noibatSalons = new ArrayList<>();
        noibatSalons.add(new SalonhelperFeature(R.drawable.luxuryman, "Luxury Salon", "60 Điện Biên Phủ"));
        noibatSalons.add(new SalonhelperFeature(R.drawable.toclangtu, "Lãng tử Salon", "41 Phạm Văn Nghị"));
        noibatSalons.add(new SalonhelperFeature(R.drawable.naubarber, "Nâu barber Salon", "694 Trần Cao Vân"));
        adapter = new noibatSalonAdapter(noibatSalons);
        noibatRecycler.setAdapter(adapter);
//        Drawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }
    private void dvNoibatRecycler() {
        dvnoibatRecycler.setHasFixedSize(true);
        dvnoibatRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Dichvu> dichvus = new ArrayList<>();
        dichvus.add(new Dichvu(R.drawable.combo10buoc30shine, "Combo 10 bước", "80K", "30Shine"));
        dichvus.add(new Dichvu(R.drawable.cb10buocluxury, "Combo 10 bước", "100K", "Luxury Salon"));
        dichvus.add(new Dichvu(R.drawable.uonhan8capdo, "Uốn hàn quốc 8 cấp", "260K", "30Shine"));
        adapter = new noibatDichvuAdapter(dichvus);
        dvnoibatRecycler.setAdapter(adapter);
//        Drawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
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
        Salon s30shine = new Salon("30Shine tiệm cắt tóc chuyên nghiệp", "40 Cao Thắng, Hải Châu, Đà Nẵng",
                R.drawable.image30shine, 4.6f);
        salons.add(s30shine);


        Salon salonloc = new Salon("Salon Lộc","40 Trưng Nữ Vương", R.drawable.salonloc, 4.2f);
        salons.add(salonloc);

        return salons;
    }
}