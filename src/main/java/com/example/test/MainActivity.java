package com.example.test;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

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
    TabItem tabUsage;


    String appID = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);*/

/*        appID = getAppConfig();

        if (appID.isEmpty()) {
            AppConfigDialog dialog = new AppConfigDialog();
            dialog.show(getSupportFragmentManager(), "AppConfigDialog");
            finishActivity(0);
            return;
        } else {*/


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


            tabCrash = findViewById(R.id.tabCrash);
            tabNetwork = findViewById(R.id.tabNetwork);
            tabFlows = findViewById(R.id.tabFlows);
            tabUsage = findViewById(R.id.tabUsage);

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

/*    public static class AppConfigDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("AppID not configured in Workspace ONE");
            builder.setMessage("\n1 - Close this App\n\n2 - Add AppID and respective value for this app in Workspace ONE UEM Console\n\n 3 - Redeploy the App");

            builder.setPositiveButton("OK", (new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // do something here
                }
            }));

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // You don't have to do anything here if you just
                    // want it dismissed when clicked
                }
            });

            // Create the AlertDialog object and return it
            return builder.create();
        }
    }*/
}

