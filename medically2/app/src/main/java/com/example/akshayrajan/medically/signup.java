package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akshay rajan on 22-03-2018.
 */

public class signup  extends Activity {

    private Button mbutton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mbutton = (Button) findViewById(R.id.Submitit);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), patientDetailsScreen3.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Logged In.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
