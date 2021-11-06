package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.Class.DichvuItemSpinner;
import com.example.appbarber.R;
import com.example.appbarber.adapter.DichvuSpinnerAdapter;

import java.util.ArrayList;

public class DatLichActivity extends AppCompatActivity {
private ArrayList<DichvuItemSpinner> dichvuLists;
private DichvuSpinnerAdapter dichvuSpinnerAdapter;
CalendarView calendarView;
RadioGroup radioGroupTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich);
        initListDvSpinner();
        TextView textViewHidden = findViewById(R.id.textViewHidden);
        textViewHidden.setVisibility(View.INVISIBLE);
        TextView textViewTimeHidden = findViewById(R.id.textHiddenTime);
        textViewTimeHidden.setVisibility(View.INVISIBLE);
        Spinner spinnerDichvu = findViewById(R.id.spinnerDV);
        dichvuSpinnerAdapter = new DichvuSpinnerAdapter(this, dichvuLists);
        spinnerDichvu.setAdapter(dichvuSpinnerAdapter);
        Button btnTieptuc = findViewById(R.id.btn_tieptuc);
        calendarView = findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                textViewHidden.setText(i2 + "/" + i1 + "/" +i);
            }
        });
        radioGroupTime = findViewById(R.id.radioGrTime);


        radioGroupTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String time = ((RadioButton)findViewById(radioGroupTime.getCheckedRadioButtonId())).getText().toString();
                textViewTimeHidden.setText(time);
            }
        });
        TextView tenDV = findViewById(R.id.textHiddenDV);
        tenDV.setVisibility(View.INVISIBLE);
        Spinner spinnerDV = findViewById(R.id.spinnerDV);
        spinnerDichvu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                DichvuItemSpinner dichvuItemSpinner = (DichvuItemSpinner) adapterView.getItemAtPosition(i);
                String dvnhan = dichvuItemSpinner.getTenDichvu();
                tenDV.setText(dvnhan);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatLichActivity.this, XacNhanActivity.class);
                intent.putExtra("gio", textViewTimeHidden.getText());
                intent.putExtra("ngayDat", textViewHidden.getText());
                intent.putExtra("dichvu", tenDV.getText());
                startActivity(intent);
            }
        });

    }

    private void initListDvSpinner() {
        dichvuLists = new ArrayList<>();
        dichvuLists.add(new DichvuItemSpinner("Cắt tóc", 20, 50000));
        dichvuLists.add(new DichvuItemSpinner("Combo 10 bước", 45, 100000));
        dichvuLists.add(new DichvuItemSpinner("Combo 7 bước", 30, 80000));
        dichvuLists.add(new DichvuItemSpinner("Nhuộm tóc", 60, 200000));
    }
}