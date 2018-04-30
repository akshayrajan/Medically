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

public class EnterPIDbypatient extends Activity {
    private Button mbutton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterpidbypatient);


        mbutton = (Button) findViewById(R.id.buttonTOenter);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), signUpforIndividualHospital.class);
                startActivity(i);
            }
        });

        mbutton = (Button) findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Check email for PID.",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}