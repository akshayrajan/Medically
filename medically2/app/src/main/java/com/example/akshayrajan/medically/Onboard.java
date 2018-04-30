package com.example.akshayrajan.medically;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

import android.Manifest;

public class Onboard extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        int times = pref.getInt("times", 0); // getting String
        // Permission Step
        addFragment(new Step.Builder().setTitle("Alternative Medicine Searching")
                .setContent("Find efficient alternative medicines for better prices")
                .setBackgroundColor(Color.parseColor("#FF0957")) // int background color
                .setDrawable(R.drawable.img2) // int top drawable
                .setSummary("VYRO: App for Doctors, Patients and Pharmacies")
                .build());
        // Permission Step
        addFragment(new PermissionStep.Builder().setTitle("Find Nearby Pharmacies")
                .setContent("Find your medicines in the shortest available distance")
                .setBackgroundColor(Color.parseColor("#FF0957")) // int background color
                .setDrawable(R.drawable.img3) // int top drawable
                .setSummary("VYRO: App for Doctors, Patients and Pharmacies")
                .setPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION})
                .build());
        //set times to 1
        if (times != 0) {
            //Move to other a activity
        }
    }

    @Override
    public void finishTutorial() {
        // Your implementation
        Intent i = new Intent();
        i.setClass(Onboard.this, bottomLogin.class);
        startActivity(i);
    }

}
