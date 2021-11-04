package com.example.appbarber.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.R;

public class ShowDetailSalonActivity extends AppCompatActivity {
TextView textnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_salon);
        textnhan = findViewById(R.id.textnhan);
        textnhan.setText(getIntent().getStringExtra("name"));
    }
}