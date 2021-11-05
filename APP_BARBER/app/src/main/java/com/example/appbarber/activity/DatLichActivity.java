package com.example.appbarber.activity;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.Class.DichvuItemSpinner;
import com.example.appbarber.R;
import com.example.appbarber.adapter.DichvuSpinnerAdapter;

import java.util.ArrayList;

public class DatLichActivity extends AppCompatActivity {
private ArrayList<DichvuItemSpinner> dichvuLists;
private DichvuSpinnerAdapter dichvuSpinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich);
        initListDvSpinner();
        Spinner spinnerDichvu = findViewById(R.id.spinnerDV);
        dichvuSpinnerAdapter = new DichvuSpinnerAdapter(this, dichvuLists);
        spinnerDichvu.setAdapter(dichvuSpinnerAdapter);
    }

    private void initListDvSpinner() {
        dichvuLists = new ArrayList<>();
        dichvuLists.add(new DichvuItemSpinner("Cắt tóc", 20, 50000));
        dichvuLists.add(new DichvuItemSpinner("Combo 10 bước", 45, 100000));
        dichvuLists.add(new DichvuItemSpinner("Combo 7 bước", 30, 80000));
        dichvuLists.add(new DichvuItemSpinner("Nhuộm tóc", 60, 200000));
    }
}