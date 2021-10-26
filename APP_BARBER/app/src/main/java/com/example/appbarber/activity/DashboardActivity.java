package com.example.appbarber.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appbarber.R;
import com.example.appbarber.fragment.HomeFragment;
import com.example.appbarber.fragment.LichFragment;
import com.example.appbarber.fragment.TaikhoanFragment;
import com.example.appbarber.fragment.ThongbaoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId())
                    {
                        case R.id.home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.lichhen:
                            fragment = new LichFragment();
                         break;

                        case R.id.thongbao:
                           fragment = new ThongbaoFragment();
                            break;

                       case R.id.taikhoan:
                           fragment = new TaikhoanFragment();
                            break;
                        }
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                }
            };



}