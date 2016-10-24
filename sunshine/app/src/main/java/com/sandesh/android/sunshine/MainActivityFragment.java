package com.sandesh.android.sunshine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivityFragment extends Fragment {
    public MainActivityFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container,false);
        String[] x={"xx","yy","zz","aa","bb"};

        List<String> y=new ArrayList<String>(Arrays.asList(x));
        ListView z=(ListView)v.findViewById(R.id.listview);

        ArrayAdapter<String> l=new ArrayAdapter<String>(getActivity(), R.layout.fragment_main,R.id.container,y);

        z.setAdapter(l);
        return v;
    }
}
