package com.example.appbarber;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class LoginAdapter extends FragmentStateAdapter {
    public LoginAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new SignupFragment();


        }
        return new LoginFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
//    private Context context;
//    int totalTabs;
//    public LoginAdapter(FragmentManager fm, Context context, int totalTabs){
//        super(fm);
//        this.context = context;
//        this.totalTabs = totalTabs;
//    }
//
//    @Override
//    public int getCount() {
//        return totalTabs;
//    }
//
//    public Fragment getItem(int position){
//        switch (position){
//            case 0:
//                LoginTabFragment loginTabFragment = new LoginTabFragment();
//                return loginTabFragment;
//            case 1:
//                SignupTabFragment signupTabFragment = new SignupTabFragment();
//                return signupTabFragment;
//            default:
//                return null;
//        }
//    }

}
