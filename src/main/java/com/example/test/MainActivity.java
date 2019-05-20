package com.example.test;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;


import com.crittercism.app.Crittercism;
import com.crittercism.app.CrittercismCallback;
import com.crittercism.app.CrittercismConfig;
import com.crittercism.app.CrashData;
//import com.crittercism.error.CRXMLHttpRequestException;
//import com.crittercism.app.CritterCallback;

/**
 * Main application object.
 *
 * @author Sylvie Ngo
 */


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize Crittercism
        Crittercism.initialize(getApplicationContext(), "61b7fd650b2f4cf58fc72478b16f38f700555300");

        setContentView(R.layout.activity_main);
    }

    public void btnerror (View view)
    {
        Button errorbutton = findViewById(R.id.error_button);
        TextView t1 = findViewById(R.id.title);
        TextView text = findViewById(R.id.use_case);

        t1.setTextColor(Color.parseColor("#FF4500"));
        text.setTextColor(Color.parseColor("#FF4500"));
        errorbutton.setTextColor(Color.parseColor("#FF4500"));

    }
/*        Button errorbutton = findViewById(R.id.error_button);
        errorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click

            }
        });*/

}

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
