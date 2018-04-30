package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by akshay rajan on 22-03-2018.
 */

public class listofhospitals extends Activity {

    private TextView mTextView=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofhospitals);

        mTextView = (TextView) findViewById(R.id.johnshospital);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),individualhospital.class);
                startActivity(i);
            }
        });
        mTextView = (TextView) findViewById(R.id.colombiaasis);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),individualhospital.class);
                startActivity(i);
            }
        });
        mTextView = (TextView) findViewById(R.id.colombiaamerica);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), individualhospital.class);
                startActivity(i);
            }
        });
    }
}