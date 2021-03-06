package com.example.appbarber.activity;
import static android.app.ActivityOptions.makeSceneTransitionAnimation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarber.R;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;


    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image = findViewById(R.id.logo_home);
        logo = findViewById(R.id.slogan_home);
        slogan = findViewById(R.id.name_app);
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(MainActivity.this, OnBoardActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logo, "logo_text");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = makeSceneTransitionAnimation(MainActivity.this, pairs);
//                    startActivity(intent, options.toBundle());
                }
            }
        },SPLASH_SCREEN);
        // T???m d???ng app 1.5 gi??y
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences userPref = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                boolean isLoggedIn = userPref.getBoolean("isLoggedIn", false);

                if (isLoggedIn){
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                    finish();
                }else {
                    isFirstTime();
                }
            }
        }, 1500);

    }
    private void isFirstTime() {
        // ki???m tra ch???y app l???n ?????u
        SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("isFirstTime", true);
        // set gi?? tr??? m???c ?????nh
        if (isFirstTime){
            SharedPreferences.Editor  editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();

            // B???t ?????u Activity Onboard
            startActivity(new Intent(MainActivity.this, OnBoardActivity.class));
            finish();
        }else {
            // B???t ?????u Auth Activity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}