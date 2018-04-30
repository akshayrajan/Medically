package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by akshay rajan on 22-03-2018.
 */

public class passwordchange extends Activity {
    private Button mbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordchange);
        mbutton = (Button) findViewById(R.id.button2);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), patientDetailsScreen3.class);
                Toast.makeText(getApplicationContext(), "PASSWORD UPDATED.",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}