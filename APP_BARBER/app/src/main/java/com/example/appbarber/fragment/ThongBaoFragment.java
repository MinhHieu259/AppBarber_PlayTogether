package com.example.appbarber.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.appbarber.Class.ThongBao;
import com.example.appbarber.R;
import com.example.appbarber.adapter.ThongBaoAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThongBaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThongBaoFragment extends Fragment {
    private  ListView lvThongBao;
    private  ArrayList<ThongBao> thongBaoArray;
    private ThongBaoAdapter thongBaoAdapter;
    private View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThongBaoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThongBaoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThongBaoFragment newInstance(String param1, String param2) {
        ThongBaoFragment fragment = new ThongBaoFragment();
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
        view = inflater.inflate(R.layout.fragment_thong_bao, container, false);
        mapping();
        thongBaoAdapter = new ThongBaoAdapter(getContext(), R.layout.thongbao_view, thongBaoArray);
        lvThongBao.setAdapter(thongBaoAdapter);
        return view;
    }
    public void mapping(){
        lvThongBao = (ListView) view.findViewById(R.id.lvThongBao);
        thongBaoArray = new ArrayList<>();
        ThongBao thongBao = new ThongBao();
        thongBao.setTenThongBao("Đặt lịch thành công");
        thongBao.setNoiDung("Lịch cắt ngày 30/10/2021 đặt thành công tại 30 Shine");
        thongBao.setNgayThongBao("29/10/2021");
        thongBao.setGioThongBao("14:31:23");
        ThongBao thongBao2 = new ThongBao();
        thongBao2.setTenThongBao("Hủy lịch thành công");
        thongBao2.setNoiDung("Hủy lịch cắt ngày 30/10/2021  thành công");
        thongBao2.setNgayThongBao("29/10/2021");
        thongBao2.setGioThongBao("14:31:23");
        ThongBao thongBao3 = new ThongBao();
        thongBao3.setTenThongBao("Mời bạn đánh giá dịch vụ");
        thongBao3.setNoiDung("Tiệm cắt tóc 30shine");
        thongBao3.setNgayThongBao("29/10/2021");
        thongBao3.setGioThongBao("14:31:23");
        thongBaoArray.add(thongBao);
        thongBaoArray.add(thongBao2);
        thongBaoArray.add(thongBao3);
    }
}