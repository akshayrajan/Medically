package com.example.akshayrajan.medically;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PrescriptionDetailRetrieval extends AppCompatActivity {
    private int i,length;
    private String cause[] = new String[100];
    private String date[] = new String[100];
    private String notes[] = new String[100];
    private String medicine[] = new String[100];
    private String Details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_detail_retrieval);

        Intent i2 = getIntent();
        String values = i2.getStringExtra("values");
        String presc[] = values.split("DELIMITER");
        Log.v("Prescription","Values ="+values);
        length = presc.length;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        for(i = 0; i < presc.length; i++)
        {
             myRef = database.getReference("VYRO/Prescription/"+presc[i]+"/Cause");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                        try
                        {
                            cause[i] = (dataSnapshot.getValue().toString());
                            Details = Details + "Cause: "+cause[i]+"\n";
                            Log.v("Prescription","Cause"+cause[i]);

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            Log.v("Prescription","Error Cause");
                        }
                    }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            //Date
            myRef = database.getReference("VYRO/Prescription/"+presc[i]+"/Date");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                        try
                        {
                            date[i] = (dataSnapshot.getValue().toString());
                            Details = Details + "Date: "+date[i]+"\n";
                            Log.v("Prescription","Date"+date[i]);

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            Log.v("Prescription","Error Cause");
                        }
                    }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            //Notes
            myRef = database.getReference("VYRO/Prescription/"+presc[i]+"/Note");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                        try
                        {
                            notes[i] = (dataSnapshot.getValue().toString());
                            Details = Details + "Notes: "+notes[i]+"\n";
                            Log.v("Prescription","Notes"+notes[i]);
                        }
                        catch(Exception e)
                        {
                            Log.v("Prescription","Error Notes");
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            //Medicine
            myRef = database.getReference("VYRO/Prescription/"+presc[i]+"/Medicine");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren())
                    {
                        try
                        {
                            medicine[i] = (childDataSnapshot.getKey().toString());
                            Details = Details + "Medicines: "+medicine[i]+"\n";
                            Log.v("Prescription","Medicine"+medicine[i]);

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }






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
                i.setClass(PrescriptionDetailRetrieval.this,patientDetailsScreen3.class);
                i.putExtra("length",length);
                for(int v = 0; v<length; v++)
                {
                    i.putExtra("Details",Details);
//
//                    Log.v("Details",Details);
                }
                startActivity(i);
                // close this activity
                finish();
            }
        }, 10000);
    }
}
