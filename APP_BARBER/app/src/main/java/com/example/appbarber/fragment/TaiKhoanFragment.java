package com.example.appbarber.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbarber.Constaint;
import com.example.appbarber.R;
import com.example.appbarber.activity.EditUserInfoActivity;
import com.example.appbarber.activity.YeuThichActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaiKhoanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaiKhoanFragment extends Fragment {
    private RelativeLayout relativeLayout;
    private TextView tvUsername, txtPhone, txtAddress;
    private CircleImageView imgProfile;
    private String imgUrl = "";
    private View view;
    private SharedPreferences preferences;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaiKhoanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaiKhoanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaiKhoanFragment newInstance(String param1, String param2) {
        TaiKhoanFragment fragment = new TaiKhoanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        relativeLayout = view.findViewById(R.id.rlLayoutYeuThich);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), YeuThichActivity.class);
                startActivity(intent);
            }
        });
        tvUsername = view.findViewById(R.id.tvUserName);
        tvUsername.setOnClickListener(v->{
            Intent intent = new Intent(getContext(), EditUserInfoActivity.class);
            intent.putExtra("imgUrl", imgUrl);
            startActivity(intent);
        });
        preferences = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        txtPhone = view.findViewById(R.id.tvNumberPhone);
        txtAddress = view.findViewById(R.id.tvDiaChiUser);
        imgProfile = view.findViewById(R.id.imageOfUserName);
        getData();
        return view;
    }

    private void getData() {
        StringRequest request = new StringRequest(Request.Method.GET, Constaint.GET_INFO_USER, res->{

            try {
                JSONObject object = new JSONObject(res);
                if (object.getBoolean("success")){
                    JSONObject user = object.getJSONObject("user");
                    String name = user.getString("name");
                    String lastname = user.getString("lastname");
                    tvUsername.setText(name+" "+ lastname);
                    txtPhone.setText(user.getString("phone"));
                    txtAddress.setText(user.getString("address"));
                    Picasso.get().load(Constaint.URL+"storage/profiles/"+user.getString("photo")).into(imgProfile);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = preferences.getString("token", "");
                HashMap<String,String> map = new HashMap<>();
                map.put("Authorization","Bearer "+token);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}