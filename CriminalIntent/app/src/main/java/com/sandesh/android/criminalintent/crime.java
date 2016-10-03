package com.sandesh.android.criminalintent;


import java.util.UUID;

public class crime {
    private UUID mId;
    private String mTitle;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public crime(){
        mId=UUID.randomUUID();
    }
}