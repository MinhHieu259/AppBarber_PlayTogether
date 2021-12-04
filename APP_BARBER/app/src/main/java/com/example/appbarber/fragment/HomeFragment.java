package com.example.appbarber.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbarber.Class.Dichvu;
import com.example.appbarber.Class.Salon;
import com.example.appbarber.Class.SalonhelperFeature;
import com.example.appbarber.R;
import com.example.appbarber.activity.MapsActivity;
import com.example.appbarber.adapter.SalonAdapter;
import com.example.appbarber.adapter.noibatDichvuAdapter;
import com.example.appbarber.adapter.noibatSalonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private LinearLayout lngantoi, lnbando;
    private  RecyclerView noibatRecycler, dvnoibatRecycler;
    private  RecyclerView.Adapter adapter;
    private View view;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        lngantoi = (LinearLayout) view.findViewById(R.id.lngantoi);
        lnbando = (LinearLayout) view.findViewById(R.id.lnbando);
        lnbando.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
        setupSalonsViewPager();
        noibatRecycler =  view.findViewById(R.id.recycleNoibat);
        noibatRecycler();
        dvnoibatRecycler = view.findViewById(R.id.recycleDvNoiBat);
        dvNoibatRecycler();
        return view;
    }
    private void noibatRecycler() {
        noibatRecycler.setHasFixedSize(true);
        noibatRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<SalonhelperFeature> noibatSalons = new ArrayList<>();
        noibatSalons.add(new SalonhelperFeature(R.drawable.luxuryman, "Luxury Salon", "60 Điện Biên Phủ"));
        noibatSalons.add(new SalonhelperFeature(R.drawable.toclangtu, "Lãng tử Salon", "41 Phạm Văn Nghị"));
        noibatSalons.add(new SalonhelperFeature(R.drawable.naubarber, "Nâu barber Salon", "694 Trần Cao Vân"));
        adapter = new noibatSalonAdapter(noibatSalons);
        noibatRecycler.setAdapter(adapter);
//        Drawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }
    private void dvNoibatRecycler() {
        dvnoibatRecycler.setHasFixedSize(true);
        dvnoibatRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Dichvu> dichvus = new ArrayList<>();
        dichvus.add(new Dichvu(R.drawable.combo10buoc30shine, "Combo 10 bước", "80K", "30Shine"));
        dichvus.add(new Dichvu(R.drawable.cb10buocluxury, "Combo 10 bước", "100K", "Luxury Salon"));
        dichvus.add(new Dichvu(R.drawable.uonhan8capdo, "Uốn hàn quốc 8 cấp", "260K", "30Shine"));
        adapter = new noibatDichvuAdapter(dichvus);
        dvnoibatRecycler.setAdapter(adapter);
//        Drawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    private void setupSalonsViewPager(){
        ViewPager2 salonViewPager = view.findViewById(R.id.salonViewPager);
        salonViewPager.setClipToPadding(false);
        salonViewPager.setClipChildren(false);
        salonViewPager.setOffscreenPageLimit(3);
        salonViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        salonViewPager.setPageTransformer(compositePageTransformer);
        salonViewPager.setAdapter(new SalonAdapter(getSalons()));
    }

    private List<Salon> getSalons(){
        List<Salon> salons = new ArrayList<>();
        Salon s30shine = new Salon("30Shine tiệm cắt tóc chuyên nghiệp", "40 Cao Thắng, Hải Châu, Đà Nẵng",
                R.drawable.image30shine, 4.6f);
        salons.add(s30shine);


        Salon salonloc = new Salon("Salon Lộc","40 Trưng Nữ Vương", R.drawable.salonloc, 4.2f);
        salons.add(salonloc);

        return salons;
    }
}