package com.example.appbarber;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {
    EditText email, password;
    Button btnLogin;
    TextView forgetPass;
    CheckBox saveif;

    float v=0;
    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.pass);
        btnLogin= root.findViewById(R.id.btn_login);
        forgetPass= root.findViewById(R.id.forgotPw);
        saveif= root.findViewById(R.id.saveif);

        email.setTranslationX(800);
        password.setTranslationX(800);
        btnLogin.setTranslationX(800);
        forgetPass.setTranslationX(800);
        saveif.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        btnLogin.setAlpha(v);
        forgetPass.setAlpha(v);
        saveif.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        saveif.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();

        return root;
    }
}
