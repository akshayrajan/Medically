package com.example.akshayrajan.medically;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by akshay rajan on 30-03-2018.
 */

public class signUpforIndividualHospital extends Activity {
    private Button mbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupforindividualhospitals);


        mbutton = (Button) findViewById(R.id.Submit);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListofDoctors. class);
                startActivity(i);
            }
        });
    }
}















