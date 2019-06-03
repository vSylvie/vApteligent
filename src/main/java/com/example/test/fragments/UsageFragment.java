package com.example.test.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.test.R;
import android.view.Gravity;


/**
 * Ce fragment permet de connaître le nombre de click pour chaque bouton ==>voir comment le faire remonter sur Apteligent
 * This fragment give us the number of clicks of each button ==> find how to enable it on Apteligent.
 */
public class UsageFragment extends Fragment{
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                savedInstanceState) {

            this.v = inflater.inflate(R.layout.fragment_usage, container, false);
            final Button androidFrameButton = v.findViewById(R.id.androidButton);
            Button iosFramesButton = v.findViewById(R.id.iosButton);

            androidFrameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Android selected", Toast.LENGTH_SHORT).show();
                }
            });

            iosFramesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "iOS selected", Toast.LENGTH_SHORT).show();
                }
            });

            return this.v;
    }
}


