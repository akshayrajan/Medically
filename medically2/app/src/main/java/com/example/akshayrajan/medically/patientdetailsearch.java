package com.example.akshayrajan.medically;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class patientdetailsearch extends AppCompatActivity {
    private String s,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientdetailsearch);
        Intent i = getIntent();
        phone = i.getStringExtra("phone");
        phone = phone.replaceAll(" ","");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("VYRO/PatientPhones/"+phone);
        Log.v("Prescription","VYRO/PatientPhones/"+phone);
        s = "";
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    try {
                       s = (dataSnapshot.getValue().toString());
                        Log.v("Prescription", "Email is"+s);
                    } catch (Exception e) {
                        Log.v("Prescription","Error");
                    }
                }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("Prescription","Error");
            }
        });
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent();
                i.setClass(patientdetailsearch.this,patientfulldetails.class);
                i.putExtra("values",s);
                i.putExtra("phone",phone);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 5000);
    }
}
