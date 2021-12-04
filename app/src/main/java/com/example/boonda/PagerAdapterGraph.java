package com.example.boonda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapterGraph extends FragmentStateAdapter {
    public PagerAdapterGraph(AppCompatActivity activity){
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new WeightGraphFragment();
                break;
            case 1:
                fragment = new HeightGraphFragment();
                break;
            case 2:
                fragment = new HeadGraphFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
