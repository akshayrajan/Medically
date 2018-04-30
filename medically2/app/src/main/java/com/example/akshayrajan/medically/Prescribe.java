package com.example.akshayrajan.medically;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Prescribe extends AppCompatActivity {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private EditText medicine,notes;
    private Button medbutton,notebutton,prescribeButton;
    boolean medicineVal = true;
    private String phone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescribe);
        Intent i = getIntent();
        phone = i.getStringExtra("phone");
        email = i.getStringExtra("email");
        medicine = (EditText) findViewById(R.id.editText5);
        notes = (EditText) findViewById(R.id.editText6);
        medbutton = (Button) findViewById(R.id.button5);
        notebutton = (Button) findViewById(R.id.button6);
        prescribeButton = (Button) findViewById(R.id.button7);
        medbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medicineVal=true;
                promptSpeechInput();
            }
        });
        notebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medicineVal=false;
                promptSpeechInput();
            }
        });
        prescribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String s = randomnum();
                Toast.makeText(Prescribe.this,s,Toast.LENGTH_LONG).show();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("VYRO/Patient/"+email+"/PrescriptionID");

                String name = "prescription";

                firedata user = new firedata(s, name);
                myRef.child("prescription").setValue(name);
                myRef.child(s).setValue(name);
                String medicinesp[] = medicine.getText().toString().split(" ");
                myRef = database.getReference("VYRO/Prescription/");
                myRef.child(s).child("ConsultFee").setValue(500);
                myRef.child(s).child("Date").setValue("31/03/2018");
                myRef.child(s).child("DoctorID").setValue("ashwinatgmaildotcom");
                for(int i = 0; i<medicinesp.length;i++)
                    myRef.child(s).child("Medicine").child(medicinesp[i]).setValue("Given");
                myRef.child(s).child("Note").setValue(notes.getText().toString());
                Intent i2 = new Intent();
                i2.setClass(Prescribe.this,SendSMS1.class);
                i2.putExtra("length",medicinesp.length);
                Log.v("Prescription",String.valueOf(medicinesp.length));
                for(int i = 0; i < medicinesp.length ; i++)
                {
                    i2.putExtra("medicine"+i,medicinesp[i]);
                }
                i2.putExtra("phone",phone);
                i2.putExtra("Notes",notes.getText().toString());
                startActivity(i2);
            }
        });
    }

    public String randomnum()
    {
        Random rand = new Random();
        int value1 = rand.nextInt(10);
        while(value1==0)
        {
            value1 = rand.nextInt(10);
        }
        int value2 = rand.nextInt(10);
        int value3 = rand.nextInt(10);
        int value4 = rand.nextInt(10);
        int value5 = rand.nextInt(10);
        int value6 = rand.nextInt(10);
        String random = "pre"+String.valueOf(value1)+String.valueOf(value2)+String.valueOf(value3)+String.valueOf(value4)+String.valueOf(value5)+String.valueOf(value6);
        return random;
    }
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if(medicineVal == true)
                        medicine.setText(result.get(0));
                    else
                        notes.setText(result.get(0));
                }
                break;
            }

        }
    }
}



