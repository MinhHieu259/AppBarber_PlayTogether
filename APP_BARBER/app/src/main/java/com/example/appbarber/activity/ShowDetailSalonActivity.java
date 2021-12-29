package com.example.appbarber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class ShowDetailSalonActivity extends AppCompatActivity {
TextView nameSalon, diachi, name2;
RoundedImageView image;
Button btnDatLich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_detail_salon);
        nameSalon = findViewById(R.id.ten_detail_salon);
        name2 = findViewById(R.id.txtTensalon);
        diachi = findViewById(R.id.txtDiachi);
        image = findViewById(R.id.image_detail_salon);
        btnDatLich = findViewById(R.id.btn_datlich);
        Picasso.get().load(Constaint.URL+"storage/salon/"+getIntent().getStringExtra("image")).into(image);
        nameSalon.setText(getIntent().getStringExtra("name"));
        //image.setImageResource(getIntent().getIntExtra("image", 0));
        diachi.setText(getIntent().getStringExtra("address"));
        name2.setText(getIntent().getStringExtra("name"));
        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailSalonActivity.this, DatLichActivity.class);
                startActivity(intent);
            }
        });
    }
}