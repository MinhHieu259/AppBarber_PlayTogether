package com.example.appbarber.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appbarber.fragment.FristFragment;
import com.example.appbarber.fragment.SecondFragment;
import com.example.appbarber.fragment.ThirdFragment;

public class ThongBaoFragmentAdapter extends FragmentStateAdapter {

    public ThongBaoFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new SecondFragment();
            case 2: return new ThirdFragment();
        }


        return new FristFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
