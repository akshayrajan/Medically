package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by akshay rajan on 30-03-2018.
 */

public class ListofDoctors extends Activity {
    private Button mbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofdoctors);


        mbutton = (Button) findViewById(R.id.bookappointmentforpedia);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Check email for Booking Details.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        mbutton = (Button) findViewById(R.id.bookappointmentforent);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Check email for Booking Details.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        mbutton = (Button) findViewById(R.id.bookappointmentforgynec);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Check email for Booking Details.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        mbutton = (Button) findViewById(R.id.bookappointmentforakash);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Check email for Booking Details.",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
