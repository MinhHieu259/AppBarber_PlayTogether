package com.example.appbarber.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appbarber.Class.Salon;
import com.example.appbarber.Class.SalonAdapter;
import com.example.appbarber.R;
import com.example.appbarber.activity.DashboardActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    private List<Salon> getSalons(){
        List<Salon> salons = new ArrayList<>();

        Salon s30shine = new Salon();
        s30shine.image= R.drawable.image30shine;
        s30shine.name = "30Shine tiệm cắt tóc chuyên nghiệp";
        s30shine.address = "40 Cao Thắng, Hải Châu, Đà Nẵng";
        s30shine.rating = 4.6f;
        salons.add(s30shine);

        Salon salonloc = new Salon();
        salonloc.image= R.drawable.salonloc;
        salonloc.name = "Salon lộc tiệm cắt tóc chuyên nghiệp";
        salonloc.address = "40 Trưng Nữ Vương";
        salonloc.rating = 4.2f;
        salons.add(salonloc);

        return salons;
    }
    private void setupSalonsViewPager(){
        ViewPager2 salonsViewPager = findViewById(R.id.salonviewpager);
        SalonAdapter salonAdapter;
        salonsViewPager.setClipToPadding(false);
        salonsViewPager.setClipChildren(false);
        salonsViewPager.setOffscreenPageLimit(3);
        salonsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        salonsViewPager.setPageTransformer(compositePageTransformer);


        salonsViewPager.setAdapter(new Salon(getSalons()));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_login, container,false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}