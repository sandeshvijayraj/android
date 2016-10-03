package com.sandesh.android.criminalintent;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.fragment_container);

        if (fr == null) {
            fr = new CrimeFragent();
            fm.beginTransaction().add(R.id.fragment_container, fr).commit();
        }
    }
}