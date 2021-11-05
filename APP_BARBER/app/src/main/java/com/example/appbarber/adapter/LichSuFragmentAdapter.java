package com.example.appbarber.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appbarber.fragment.SapToiFragment;
import com.example.appbarber.fragment.LichSuFragment;

public class LichSuFragmentAdapter extends FragmentStateAdapter {

    public LichSuFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new LichSuFragment();
        }

        return new SapToiFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
