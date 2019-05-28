package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;

import com.crittercism.app.Crittercism;
import com.crittercism.app.CrittercismCallback;
import com.crittercism.app.CrittercismConfig;
import com.crittercism.app.CrashData;

import com.example.test.fragments.ErrorFragment;
import com.example.test.fragments.NetworkFragment;
import com.example.test.fragments.OtherFragment;
import com.example.test.fragments.TransactionFragment;


/**
 * Main application object.
 *
 * @author Sylvie Ngo
 */


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Crittercism
        Crittercism.initialize(getApplicationContext(), "61b7fd650b2f4cf58fc72478b16f38f700555300");

        ViewPager viewPager = findViewById(R.id.pager);
        TabLayout tablayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

/*        tablayout.addTab(tablayout.newTab().setText("Crash"));
        tablayout.addTab(tablayout.newTab().setText("Perf"));
        tablayout.addTab(tablayout.newTab().setText("Usage"));
        tablayout.addTab(tablayout.newTab().setText("Network"));*/

        TabItem tabCrash = findViewById(R.id.tabCrash);
        TabItem tabNetwork = findViewById(R.id.tabNetwork);
        TabItem tabFlows = findViewById(R.id.tabFlows);
        TabItem tabOther = findViewById(R.id.tabOther);
    }

    public void btnerror (View view)
    {
        Button errorbutton = findViewById(R.id.error_button);
        TextView t1 = findViewById(R.id.title);
        TextView text = findViewById(R.id.use_case);

        t1.setTextColor(Color.parseColor("#FF0000"));
        text.setTextColor(Color.parseColor("#FF0000"));
        errorbutton.setTextColor(Color.parseColor("#FF0000"));

    }

    public void btnrollback (View view)
    {
        Button errorbutton = findViewById(R.id.error_button);
        TextView t1 = findViewById(R.id.title);
        TextView text = findViewById(R.id.use_case);

        t1.setTextColor(Color.parseColor("#000000"));
        text.setTextColor(Color.parseColor("#000000"));
        errorbutton.setTextColor(Color.parseColor("#000000"));

    }

    private int count;


    public void btniOS (View view)
    {
        TextView iOS= findViewById(R.id.counter);
        iOS.setTextColor(Color.parseColor("#000000"));
    }

    public void btnandroid (View view)
    {
        TextView t1 = findViewById(R.id.title);
        t1.setTextColor(Color.parseColor("#000000"));
    }
}

/*        Button errorbutton = findViewById(R.id.error_button);
          errorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click

            }
        });*/

        //public static void getPreviousSessionCrashData (CrittercismCallback<CrashData> crashListener)

/*        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //add app icon inside the toolbar
        //getSupportActionBar().setTitle("flow app");
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_launcher_background));*/


/*       Optional Configuration

            public static void Init(string appID)
        {
            CrittercismConfig config = new CrittercismConfig ();

            // enable logcat collection
            config.SetLogcatReportingEnabled (true);

            // set version name to myCustomVersion
            config.SetCustomVersionName ("myCustomVersion");

            Init (appID, config);
        }*/

/*        Crittercism.SetLogUnhandledExceptionAsCrash(value);
          Crittercism.GetLogUnhandledExceptionAsCrash();

        void CallCriticalBusinessFunction() {
            try {
                SetLogUnhandledExceptionAsCrash(true);
                CriticalBusinessFunction();
            } finally {
                SetLogUnhandledExceptionAsCrash(false);
            }
        }*/
