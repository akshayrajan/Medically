package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by akshay rajan on 24-03-2018.
 */

public class loginfordruggist  extends Activity {

    private Button mbutton = null;
    private TextView mTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginfordruggist);

        mbutton = (Button) findViewById(R.id.loginbutton);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), shopkeeperdetailspage.class);
                startActivity(i);
            }
        });
    }
}

