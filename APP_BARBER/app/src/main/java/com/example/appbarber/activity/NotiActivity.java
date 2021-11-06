package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.Class.SalonNoti;
import com.example.appbarber.Class.ThongBao;
import com.example.appbarber.R;
import com.example.appbarber.adapter.SaLonNotiAdapter;
import com.example.appbarber.adapter.ThongBaoAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class NotiActivity extends AppCompatActivity {
    ListView lvThongBao;
    ArrayList<ThongBao> thongBaoArray;
    ThongBaoAdapter thongBaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_noti);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.thongbao);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , DashboardActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.lichhen:
                        startActivity(new Intent(getApplicationContext()
                                , CalendarActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.thongbao:
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
        mapping();
        thongBaoAdapter = new ThongBaoAdapter(NotiActivity.this, R.layout.thongbao_view, thongBaoArray);
        lvThongBao.setAdapter(thongBaoAdapter);

    }

    public void mapping(){
        lvThongBao = (ListView) findViewById(R.id.lvThongBao);
        thongBaoArray = new ArrayList<>();
        ThongBao thongBao = new ThongBao();
        thongBao.setTenThongBao("Đặt lịch thành công");
        thongBao.setNoiDung("Lịch cắt ngày 30/10/2021 đặt thành công tại 30 Shine");
        thongBao.setNgayThongBao("29/10/2021");
        thongBao.setGioThongBao("14:31:23");
        ThongBao thongBao2 = new ThongBao();
        thongBao2.setTenThongBao("Hủy lịch thành công");
        thongBao2.setNoiDung("Hủy lịch cắt ngày 30/10/2021  thành công");
        thongBao2.setNgayThongBao("29/10/2021");
        thongBao2.setGioThongBao("14:31:23");
        ThongBao thongBao3 = new ThongBao();
        thongBao3.setTenThongBao("Mời bạn đánh giá dịch vụ");
        thongBao3.setNoiDung("Tiệm cắt tóc 30shine");
        thongBao3.setNgayThongBao("29/10/2021");
        thongBao3.setGioThongBao("14:31:23");
        thongBaoArray.add(thongBao);
        thongBaoArray.add(thongBao2);
        thongBaoArray.add(thongBao3);
    }
}