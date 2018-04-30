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

public class individualhospital extends Activity {
    private Button mButton=null;
    private TextView mTextView=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individualhospital);

        mButton = (Button) findViewById(R.id.findmedicinebutton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), shopDetails.class);
                startActivity(i);
            }
        });

        mTextView = (TextView) findViewById(R.id.textView2);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),medicinedetailsandcomponents.class);
                startActivity(i);
            }
        });

    }
}