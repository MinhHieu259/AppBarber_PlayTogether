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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends AppCompatActivity {
    private TextInputLayout layoutName, layoutLastName, layoutPhone, layoutAddress;
    private TextInputEditText txtName, txtLastName, txtPhone, txtAddress;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_info);
        init();
    }
    private void init(){
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        layoutName = findViewById(R.id.txtLayoutNameUserInfo);
        layoutLastName = findViewById(R.id.txtLayoutLastNameUserInfo);
        layoutPhone = findViewById(R.id.txtLayoutPhoneUserInfo);
        layoutAddress = findViewById(R.id.txtLayoutAddressUserInfo);
        txtName = findViewById(R.id.txtNameUserInfo);
        txtLastName = findViewById(R.id.txtLastNameUserInfo);
        txtPhone = findViewById(R.id.txtPhoneUserInfo);
        txtAddress = findViewById(R.id.txtAddressUserInfo);
        txtSelectedPhoto = findViewById(R.id.txtSelectPhoto);
        btn_continue = findViewById(R.id.btn_Continue);
        circleImageView = findViewById(R.id.imgUserInfo);

        //pick photo from gallery
        txtSelectedPhoto.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            startActivityForResult(i, GALLERY_ADD_PROFILE);
        });

        btn_continue.setOnClickListener(v->{
            if (validate()){
                saveuserinfo();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALLERY_ADD_PROFILE && resultCode == RESULT_OK){
            Uri imgUri = data.getData();
            circleImageView.setImageURI(imgUri);

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri);
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
    private void saveuserinfo(){
        dialog.setMessage("??ang l??u th??ng tin");
        dialog.show();
        String name = txtName.getText().toString().trim();
        String lastname = txtLastName.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        String address = txtAddress.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.POST, Constaint.SAVE_USER_INFO, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")){
                    JSONObject userObject = object.getJSONObject("user");
                    SharedPreferences.Editor editor = userPref.edit();
                    editor.putString("name", userObject.getString("name"));
                    editor.putString("lastname", userObject.getString("lastname"));
                    editor.putString("photo", object.getString("photo"));
                    editor.putString("phone", phone);
                    editor.putString("address", address);
                    editor.apply();
                    startActivity(new Intent(UserInfoActivity.this, DashboardActivity.class));
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dialog.dismiss();
        },error -> {
            error.printStackTrace();
            dialog.dismiss();
        }){
            // add token to header

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = userPref.getString("token", "");
                HashMap<String,String> map = new HashMap<>();
                map.put("Authorization","Bearer "+token);
                return map;
            }

            // add param

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("name", name);
                map.put("lastname", lastname);
                map.put("phone", phone);
                map.put("address", address);
                map.put("photo",bitmapToString(bitmap));
                return  map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(UserInfoActivity.this);
        queue.add(request);
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