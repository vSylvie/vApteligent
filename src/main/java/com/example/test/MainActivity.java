package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.RestrictionsManager;
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
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.crittercism.app.Crittercism;


/**
 * Main application object.
 *
 * @author Sylvie Ngo
 */


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    PagerAdapter pageAdapter;
    TabItem tabCrash;
    TabItem tabNetwork;
    TabItem tabFlows;
    TabItem tabOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Crittercism
        Crittercism.initialize(getApplicationContext(), "61b7fd650b2f4cf58fc72478b16f38f700555300");


        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("WSO INTELLIGENCE");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


/*        tabLayout.addTab(tabLayout.newTab().setText("CRASH"));
        tabLayout.addTab(tabLayout.newTab().setText("NETWORK"));
        tabLayout.addTab(tabLayout.newTab().setText("FLOWS"));
        tabLayout.addTab(tabLayout.newTab().setText("OTHER"));*/


        tabCrash = findViewById(R.id.tabCrash);
        tabNetwork = findViewById(R.id.tabNetwork);
        tabFlows = findViewById(R.id.tabFlows);
        //tabOther = findViewById(R.id.tabOther);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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

    // Application Configuration method
    // Expect from Workspace ONE UEM the AppID and Sandbox parameters
    // AppID - appid created when application is registered in Workspace ONE Intelligence
    // Sandbox - when true app analytics will be sent to the sandbox environment, otherwise goes to production
    protected String getAppConfig() {
        RestrictionsManager appRestrictions =
                (RestrictionsManager) getApplicationContext()
                        .getSystemService(Context.RESTRICTIONS_SERVICE);

        if (appRestrictions.getApplicationRestrictions().containsKey("Sandbox")) {
            if ( appRestrictions.getApplicationRestrictions().getBoolean("Sandbox") ) {
                System.setProperty("com.crittercism.dhubConfigUrl", "https://api.sandbox.data.vmwservices.com");
                System.setProperty("com.crittercism.dhubEventsUrl", "https://api.sandbox.data.vmwservices.com");
            }
        }

        if (appRestrictions.getApplicationRestrictions().containsKey("AppID")) {
            return appRestrictions.getApplicationRestrictions().getString("AppID");
        } else {
            // no appID provided
            return new String();
        }

    }
}
