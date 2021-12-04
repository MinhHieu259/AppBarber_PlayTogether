package com.example.appbarber.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.appbarber.R;
import com.example.appbarber.fragment.HomeFragment;
import com.example.appbarber.fragment.LichFragment;
import com.example.appbarber.fragment.TaiKhoanFragment;
import com.example.appbarber.fragment.ThongBaoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        navigationView = findViewById(R.id.bottom_nav);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameHomeContainer, new HomeFragment(),HomeFragment.class.getSimpleName()).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.lichhen:
                        selectedFragment = new LichFragment();
                        break;
                    case R.id.thongbao:
                        selectedFragment = new ThongBaoFragment();
                        break;
                    case R.id.taikhoan:
                        selectedFragment = new TaiKhoanFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameHomeContainer,
                        selectedFragment).commit();
                return true;

            }
        });
    }
    }


