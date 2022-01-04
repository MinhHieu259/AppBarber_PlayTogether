package com.example.appbarber.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditUserInfoActivity extends AppCompatActivity {
    private TextInputLayout layoutName, layoutLastName;
    private TextInputEditText txtName, txtLastName;
    private Button btn_continue;
    private TextView txtSelectedPhoto;
    private CircleImageView circleImageView;
    private static final int GALLERY_ADD_PROFILE = 1;
    private Bitmap bitmap = null;
    private SharedPreferences userPref;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);
        init();
    }
    public void init(){
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        layoutName = findViewById(R.id.txtEditLayoutNameUserInfo);
        layoutLastName = findViewById(R.id.txtEditLayoutLastNameUserInfo);
        txtName = findViewById(R.id.txtEditNameUserInfo);
        txtLastName = findViewById(R.id.txtEditLastNameUserInfo);
        txtSelectedPhoto = findViewById(R.id.txtEditSelectPhoto);
        btn_continue = findViewById(R.id.btn_Edit_Save);
        circleImageView = findViewById(R.id.imgEditUserInfo);
    }
}