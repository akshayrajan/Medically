package com.example.akshayrajan.medically;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class doctordisplay extends AppCompatActivity {
    private String dob,name,phone,prescriptionid,sideeffectskeys,sideeffectvalues,email;
    private TextView tv;
    private Button button3,button4;
    private StringBuilder s = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordisplay);

        Intent i = getIntent();
        dob = i.getStringExtra("DOB");
        email = i.getStringExtra("email");
        name = i.getStringExtra("FullName");
        phone = i.getStringExtra("Phone");
        prescriptionid = i.getStringExtra("prescriptionid");
        sideeffectskeys = i.getStringExtra("sideeffectkeys");
        sideeffectvalues = i.getStringExtra("sideeffectvalues");
        tv = (TextView) findViewById(R.id.textView13);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        String sideeffectkey[] = sideeffectskeys.split("DELIMITER");
        String sideeffectvalue[] = sideeffectvalues.split("DELIMITER");
        StringBuilder s2 = new StringBuilder();
        for(int v=0;v<sideeffectkey.length;v++)
        {
            s2.append("\nMedicine: "+sideeffectkey[v]+" and side effect: "+sideeffectvalue[v]);
        }
        s.append("Full Name: "+name+"\nDate Of Birth "+dob+"\nPhone Number: "+phone);
        s.append(s2);
        tv.setText(s.toString());
        //Prescriptions
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(doctordisplay.this,PrescriptionDetailRetrieval.class);
                i.putExtra("values",prescriptionid);
                startActivity(i);
            }
        });
        //Prescribe
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(doctordisplay.this,Prescribe.class);
                i.putExtra("phone",phone);
                i.putExtra("email",email);
                startActivity(i);
            }
        });
    }
}
