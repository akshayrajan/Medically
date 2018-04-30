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

public class patientfulldetails extends AppCompatActivity {
    private String email,phone;
    private String dob, name, prescriptionid, sideeffectskeys, sideeffectvalues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientfulldetails);
        Intent i = getIntent();
     //   i.setClass(patientfulldetails.this,doctorShow.class);
        email = i.getStringExtra("values");
        phone = i.getStringExtra("phone");
        if(email==null)
        {
            email = "beinggvatgmaildotcom";
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("VYRO/Patient/"+email+"/DOB");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    dob = (dataSnapshot.getValue().toString());
                    Log.v("Prescription", "DOB is"+dob);
                } catch (Exception e) {
                    Log.v("Prescription","Error");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef = database.getReference("VYRO/Patient/"+email+"/FullName");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    name = (dataSnapshot.getValue().toString());
                    Log.v("Prescription", "Full Name is"+name);
                } catch (Exception e) {
                    Log.v("Prescription","Error");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef = database.getReference("VYRO/Patient/" + email + "/PrescriptionID");
        Log.d("LOCATION", "Value is: " + "VYRO/Patient/" + email + "/PrescriptionID");
        prescriptionid = "";
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    try {
                        prescriptionid = prescriptionid + (childDataSnapshot.getKey().toString());
                        prescriptionid = prescriptionid + "DELIMITER";
                        Log.v("Prescription", prescriptionid);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef = database.getReference("VYRO/Patient/" + email + "/Side Effects");
        Log.d("LOCATION", "Value is: " + "VYRO/Patient/" + email + "/Side Effects");
        sideeffectskeys = "";
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    try {
                        sideeffectskeys = sideeffectskeys + (childDataSnapshot.getKey().toString());
                        sideeffectskeys = sideeffectskeys + "DELIMITER";
                        Log.v("Prescription", sideeffectskeys);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef = database.getReference("VYRO/Patient/" + email + "/Side Effects");
        Log.d("LOCATION", "Value is: " + "VYRO/Patient/" + email + "/Side Effects");
        sideeffectvalues = "";
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    try {
                        sideeffectvalues = sideeffectvalues + (childDataSnapshot.getValue().toString());
                        sideeffectvalues = sideeffectvalues + "DELIMITER";
                        Log.v("Prescription", sideeffectvalues);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

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

                // close this activity
                Intent i = new Intent();
                i.putExtra("DOB",dob);
                i.putExtra("FullName",name);
                i.putExtra("email",email);
                i.putExtra("Phone",phone);
                i.putExtra("prescriptionid",prescriptionid);
                i.putExtra("sideeffectkeys",sideeffectskeys);
                i.putExtra("sideeffectvalues",sideeffectvalues);
                i.setClass(patientfulldetails.this,doctordisplay.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}
