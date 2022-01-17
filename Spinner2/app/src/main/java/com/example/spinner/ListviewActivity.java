package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListviewActivity extends AppCompatActivity {
    private ListView lv;
    private String[] number =
            {"161250533502","161250533405","151250533308","161250533207","151250533113","131250532378"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv= (ListView) findViewById(R.id.lvMaSinhVien);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,number);
        lv.setAdapter(arrayAdapter);
    }
}