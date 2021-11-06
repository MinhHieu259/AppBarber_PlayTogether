package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;

import com.example.appbarber.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_account);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.taikhoan);
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
                        startActivity(new Intent(getApplicationContext()
                                , NotiActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.taikhoan:
                        return true;
                }
                return false;
            }
        });
        relativeLayout = findViewById(R.id.rlLayoutYeuThich);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YeuThichActivity.class);
                startActivity(intent);
            }
        });
    }
}