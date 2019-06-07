package com.example.test.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.crittercism.app.Crittercism;
import com.example.test.R;
import android.view.Gravity;

import org.json.JSONException;
import org.json.JSONObject;

import static com.crittercism.app.Crittercism.leaveBreadcrumb;


/**
 * Ce fragment permet de connaître le nombre de click pour chaque bouton ==>voir comment le faire remonter sur Apteligent
 * This fragment give us the number of clicks of each button ==> find how to enable it on Apteligent.
 */
public class UsageFragment extends Fragment{
    private View v;
    private int cmp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                savedInstanceState) {

            this.v = inflater.inflate(R.layout.fragment_usage, container, false);

   /*         Button androidFrameButton = v.findViewById(R.id.androidButton);
            Button iosFramesButton = v.findViewById(R.id.iosButton);

            androidFrameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Crittercism.leaveBreadcrumb("Android");
                    //Toast.makeText(getActivity(), "Android selected", Toast.LENGTH_SHORT).show();

                }
            });

            iosFramesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Crittercism.leaveBreadcrumb("iOS");
                    //Toast.makeText(getActivity(), "iOS selected", Toast.LENGTH_SHORT).show();
                }
            });
            return this.v;
    }*/

        setButtonAction(v, R.id.usernameBobButton, new UserNameButtonAction("Bob", "The user Bob was chosen."));
        setButtonAction(v, R.id.usernameSueButton, new UserNameButtonAction("Sue", "The user Sue was chosen."));
        setButtonAction(v, R.id.usernameJoeButton, new UserNameButtonAction("Joe", "tThe user Joe was chosen."));

        setButtonAction(v, R.id.level1Button, new MetadataButtonAction("Game Level", "Level 1"));
        setButtonAction(v, R.id.level5Button, new MetadataButtonAction("Game Level", "Level 5"));
        setButtonAction(v, R.id.level7Button, new MetadataButtonAction("Game Level", "Level 7"));

        setButtonAction(v, R.id.optInButton, new OptOutButtonAction(false));
        setButtonAction(v, R.id.optOutButton, new OptOutButtonAction(true));

        updateOptOutStatusLabel();

        setButtonAction(v, R.id.androidButton, new PollButtonAction("Android", "The user chose Android."));
        setButtonAction(v, R.id.iosButton, new PollButtonAction("iOS", "The user chose iOS."));

        return v;
    }

    private void setButtonAction(View v, int id, View.OnClickListener listener) {
        Button button = v.findViewById(id);
        button.setOnClickListener(listener);
    }

    private void updateOptOutStatusLabel() {
        TextView textView = this.v.findViewById(R.id.statusText);
        boolean currentStatus = Crittercism.getOptOutStatus();
        textView.setText("OPT-OUT STATUS: " + currentStatus);
    }

    private class UserNameButtonAction implements View.OnClickListener {

        private String breadcrumb;
        private String username;

        private UserNameButtonAction(String username, String breadcrumb) {
            this.username = username;
            this.breadcrumb = breadcrumb;
        }

        @Override
        public void onClick(View v) {

            Crittercism.setUsername(this.username);
            Crittercism.leaveBreadcrumb(this.breadcrumb);
            Toast.makeText(getActivity(), this.username +" selected", Toast.LENGTH_SHORT).show();
        }
    }

    private class MetadataButtonAction implements View.OnClickListener {
        private String key;
        private String value;

        private MetadataButtonAction(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public void onClick(View v) {
            JSONObject json = new JSONObject();

            try {
                json.putOpt(key, value);
            } catch (JSONException e) {
                throw new AssertionError("Bad key/value: " + key + " " + value);
            }

            Crittercism.setMetadata(json);

            Toast.makeText(getActivity(),  this.value +" selected", Toast.LENGTH_SHORT).show();
        }
    }

    private class OptOutButtonAction implements View.OnClickListener {
        private boolean shouldOptOut;

        private OptOutButtonAction(boolean shouldOptOut) {
            this.shouldOptOut = shouldOptOut;
        }

        @Override
        public void onClick(View v) {
            Crittercism.setOptOutStatus(this.shouldOptOut);
            UsageFragment.this.updateOptOutStatusLabel();
            Toast.makeText(getActivity(), "Opt selected", Toast.LENGTH_SHORT).show();
        }
    }

    private class PollButtonAction implements View.OnClickListener {

        private String brand;
        private String breadcrumb;
        private int cmp;

        private PollButtonAction(String brand, String breadcrumb) {
            this.brand = brand;
            this.breadcrumb=breadcrumb;
        }

        @Override
        public void onClick(View v) {
            cmp++;
            Crittercism.leaveBreadcrumb(this.breadcrumb);
            Toast.makeText(getActivity(),  brand+ " was selected " +cmp+ " times" , Toast.LENGTH_SHORT).show();}

    }
}


