package com.example.appbarber.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditUserInfoActivity extends AppCompatActivity {
    private TextInputLayout layoutName, layoutLastName,layoutPhone, layoutAddress;
    private TextInputEditText txtName, txtLastName, txtPhone, txtAddress;
    private Button btn_save;
    private TextView txtSelectedPhoto;
    private CircleImageView circleImageView;
    private static final int GALLERY_CHANGE_PROFILE = 5;
    private Bitmap bitmap = null;
    private SharedPreferences userPref;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_edit_user_info);
        init();
    }
    public void init(){
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        layoutName = findViewById(R.id.txtEditLayoutNameUserInfo);
        layoutLastName = findViewById(R.id.txtEditLayoutLastNameUserInfo);
        layoutPhone = findViewById(R.id.txtEditLayoutPhoneUserInfo);
        layoutAddress = findViewById(R.id.txtEditLayoutAddressUserInfo);
        txtName = findViewById(R.id.txtEditNameUserInfo);
        txtLastName = findViewById(R.id.txtEditLastNameUserInfo);
        txtPhone = findViewById(R.id.txtEditPhoneUserInfo);
        txtAddress = findViewById(R.id.txtEditAddressUserInfo);
        txtSelectedPhoto = findViewById(R.id.txtEditSelectPhoto);
        btn_save = findViewById(R.id.btn_Edit_Save);
        circleImageView = findViewById(R.id.imgEditUserInfo);

        Picasso.get().load(getIntent().getStringExtra("imgUrl")).into(circleImageView);
        txtName.setText(userPref.getString("name", ""));
        txtLastName.setText(userPref.getString("lastname", ""));
        txtPhone.setText(userPref.getString("phone", ""));
        txtAddress.setText(userPref.getString("address", ""));
        txtSelectedPhoto.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            startActivityForResult(i, GALLERY_CHANGE_PROFILE);
        });
        btn_save.setOnClickListener(v->{
            if (validate()){
                updateProfile();
            }
        });
    }
    public void updateProfile(){
        dialog.setMessage("??ang x??? l??");
        dialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, Constaint.SAVE_USER_INFO, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")){
                    JSONObject user = object.getJSONObject("user");
                    SharedPreferences.Editor editor = userPref.edit();
                    editor.putString("name", txtName.getText().toString().trim());
                    editor.putString("lastname", txtLastName.getText().toString().trim());
                    editor.putString("phone", user.getString("phone"));
                    editor.putString("address", user.getString("address"));
                    editor.apply();
                    Toast.makeText(this, "C???p nh???t th??ng tin th??nh c??ng", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dialog.dismiss();
        }, error -> {
            error.printStackTrace();
            dialog.dismiss();
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = userPref.getString("token", "");
                HashMap<String,String> map = new HashMap<>();
                map.put("Authorization","Bearer "+token);
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("name", txtName.getText().toString().trim());
                map.put("lastname", txtLastName.getText().toString().trim());
                map.put("photo", bitmapToString(bitmap));
                map.put("phone", txtPhone.getText().toString().trim());
                map.put("address", txtAddress.getText().toString().trim());
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(EditUserInfoActivity.this);
        queue.add(request);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALLERY_CHANGE_PROFILE && resultCode==RESULT_OK){
            Uri uri = data.getData();
            circleImageView.setImageURI(uri);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean validate(){
        if (txtName.getText().toString().isEmpty()){
            layoutName.setErrorEnabled(true);
            layoutName.setError("H??? kh??ng ???????c ????? tr???ng");
            return false;
        }
        if (txtLastName.getText().toString().isEmpty()){
            layoutLastName.setErrorEnabled(true);
            layoutLastName.setError("T??n kh??ng ???????c ????? tr???ng");
            return false;
        }
        if (txtPhone.getText().toString().isEmpty()){
            layoutPhone.setErrorEnabled(true);
            layoutPhone.setError("S??? ??i???n tho???i kh??ng ???????c ????? tr???ng");
            return false;
        }
        if (txtAddress.getText().toString().isEmpty()){
            layoutAddress.setErrorEnabled(true);
            layoutAddress.setError("?????a ch??? kh??ng ???????c ????? tr???ng");
            return false;
        }

        return true;
    }
    private String bitmapToString(Bitmap bitmap) {
        if (bitmap != null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte [] array = byteArrayOutputStream.toByteArray();
            return android.util.Base64.encodeToString(array, Base64.DEFAULT);

        }
        return "";
    }
}