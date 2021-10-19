package com.example.appbarber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {
 BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
         navigationView = findViewById(R.id.bottomNavigationView);
         navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()) {
                     case R.id.homeFragment:
                         Toast.makeText(Dashboard.this, "HOME", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.calendarFragment:
                         Toast.makeText(Dashboard.this, "CALENDAR", Toast.LENGTH_SHORT).show();
                         break;
                 }

                 return true;
             }
         });


    }
}