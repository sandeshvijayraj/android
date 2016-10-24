package com.sandesh.android.sunshine;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment ff = fm.findFragmentById(R.id.container);

        if (ff == null) {
          ff = new MainActivityFragment();
            fm.beginTransaction().add(R.id.container, ff).commit();
       }
    }
}