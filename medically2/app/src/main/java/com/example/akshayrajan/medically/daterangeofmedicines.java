package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by akshay rajan on 22-03-2018.
 */

public class daterangeofmedicines extends Activity {

    private TextView mTextView=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daterangeofmedicines);

        mTextView = (TextView) findViewById(R.id.firstdaterange);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), listofhospitals.class);
                startActivity(i);
            }
        });
        mTextView = (TextView) findViewById(R.id.seconddaterange);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), listofhospitals.class);
                startActivity(i);
            }
        });

    }
}