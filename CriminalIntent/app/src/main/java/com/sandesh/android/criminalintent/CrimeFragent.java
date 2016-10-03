package com.sandesh.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CrimeFragent extends Fragment {
    private crime mCrime;

    @Override
    public void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        mCrime = new crime();
    }
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_crime, container,false);
            EditText mTitleField = (EditText)v.findViewById(R.id.crime_title_hint);
            mTitleField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {   }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mCrime.setmTitle(s.toString());
                }
                @Override
                public void afterTextChanged(Editable s) {}        });
            return v;
        }
}
