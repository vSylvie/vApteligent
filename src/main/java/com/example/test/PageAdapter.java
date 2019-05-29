package com.example.test;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.test.fragments.ErrorFragment;

public class PageAdapter extends FragmentPagerAdapter {

    PageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new ErrorFragment();
            default:
                throw new AssertionError("Unrecognized tab: " + position);
        }
    }

    @Override
    public int getCount(){return 1;}
}
