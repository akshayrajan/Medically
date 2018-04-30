package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class listOfHospitalsForPune extends Activity {
    private TextView mtextView = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofhospitalsforpune);

        mtextView = (TextView) findViewById(R.id.sayadrihospital);
        mtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EnterPIDbypatient.class);
                startActivity(i);
            }
        });


    }
}
