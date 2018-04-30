package com.example.akshayrajan.medically;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by akshay rajan on 31-03-2018.
 */

public class changepasswordforPharmacy extends Activity {
    private Button mbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepasswordforpharmacy);

        mbutton = (Button) findViewById(R.id.buttonforupdatingpharmacy);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), shopkeeperdetailspage.class);
                Toast.makeText(getApplicationContext(), "Password has been updated",
                        Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

    }
}