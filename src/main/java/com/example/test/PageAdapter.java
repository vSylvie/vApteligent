package com.example.test;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.test.fragments.ErrorFragment;
import com.example.test.fragments.NetworkFragment;
import com.example.test.fragments.UsageFragment;
import com.example.test.fragments.UserFlowsFragment;


public class PageAdapter extends FragmentPagerAdapter {

    private String[] tabTitles = new String[]{"CRASH", "NETWORK", "USAGE","USER FLOWS"};

    PageAdapter(FragmentManager fm){
        super(fm);
    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new ErrorFragment();
            case 1:
                return new NetworkFragment();
            case 2:
                return new UsageFragment();
            case 3:
                return new UserFlowsFragment();
            default:
                throw new AssertionError("Unrecognized tab: " + position);
        }
    }

    @Override
    public int getCount(){return 4;}
}
