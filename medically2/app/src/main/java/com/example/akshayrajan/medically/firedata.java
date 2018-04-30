package com.example.akshayrajan.medically;

/**
 * Created by akshay rajan on 31-03-2018.
 */

public class firedata {

    public String username;
    public String email;

    public firedata() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public firedata(String username, String email) {
        this.username = username;
        this.email = email;
    }

}

