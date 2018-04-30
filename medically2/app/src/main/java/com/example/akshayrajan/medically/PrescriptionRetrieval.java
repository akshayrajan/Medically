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

public class PrescriptionRetrieval extends AppCompatActivity {
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_retrieval);

        Intent i = getIntent();
        String email = i.getStringExtra("email");
        email = email.replaceAll("\\.","dot");
        email = email.replaceAll("@","at");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("VYRO/Patient/" + email + "/PrescriptionID");
        Log.d("LOCATION", "Value is: " + "VYRO/Patient/" + email + "/PrescriptionID");
        s = "";
        myRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                                                try {
                                                    s = s + (childDataSnapshot.getKey().toString());
                                                    s = s + "DELIMITER";
                                                    Log.v("Prescription", s);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });


        //Delay
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
                i.setClass(PrescriptionRetrieval.this,PrescriptionDetailRetrieval.class);
                i.putExtra("values",s);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 5000);
    }
}
