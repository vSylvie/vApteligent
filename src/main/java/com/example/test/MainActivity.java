package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import com.crittercism.app.Crittercism;

//import com.example.test.fragments.NetworkFragment;
import com.example.test.fragments.ErrorFragment;


/**
 * Main application object.
 *
 * @author Sylvie Ngo
 */


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter pageAdapter;
    private TabItem tabCrash;
    private TabItem tabNetwork;
    private TabItem tabFlows;
    private TabItem tabOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Crittercism
        Crittercism.initialize(getApplicationContext(), "61b7fd650b2f4cf58fc72478b16f38f700555300");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("WSO");
        toolbar.setTitleTextColor(0xF12300);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabCrash = findViewById(R.id.tabCrash);
        tabNetwork = findViewById(R.id.tabNetwork);
        tabFlows = findViewById(R.id.tabFlows);
        tabOther = findViewById(R.id.tabOther);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
