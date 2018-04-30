package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class mediaterPage extends Activity {
    private Button mbutton = null;
    private Button nbutton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaterpage);

        mbutton = (Button) findViewById(R.id.medicalhistory);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), medicalHistory.class);
                startActivity(i);
            }
        });

        mbutton = (Button) findViewById(R.id.prescribepatient);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), doctorchoiceofmedicines.class);
                startActivity(i);
            }
        });
    }

}
