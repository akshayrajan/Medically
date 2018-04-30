package com.example.akshayrajan.medically;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendSMS1 extends AppCompatActivity {
    private String length, phone, notes;
    private String generic[] = new String[5];
    private String brands[] = new String[5];
    private String temp;
    private String medicinelist[] = new String[5];
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms1);
        Intent i2 = getIntent();
        int len = i2.getIntExtra("length", 0);
        length = String.valueOf(len);

        Log.v("PrescriptionLength", length);

        String medicinesp[] = new String[Integer.parseInt(length)];
        String s = "Prescription Medicines are: ";
        for (int i = 0; i < Integer.parseInt(length); i++) {
            medicinesp[i] = i2.getStringExtra("medicine" + i);
            s = s + medicinesp[i] + ", ";
        }
        phone = i2.getStringExtra("phone");
        notes = i2.getStringExtra("Notes");
        s = s + ". Notes by Doctor: " + notes;


        String number = "&numbers=" + "9844214204";
        String sender = "&sender=" + "TXTLCL";
        String message = "&message=" + s;
        AsyncTaskRunner runner = new AsyncTaskRunner();
        runner.execute(number, message, sender);


    }

    public class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            String numbers = params[0];
            String message = params[1];
            String sender = params[2];
            try {
                // Construct data
                String apiKey = "apikey=" + "Qjb+N3PvLJw-eQTqwo1HZ8TajG4qNWQw5tbE3hhawI";
                // Send data
                HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                String data = apiKey + numbers + message + sender;
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
                rd.close();
                Log.v("SMSSent Prescription", stringBuffer.toString());

            } catch (Exception e) {
                Log.v("SMSError Prescription", e.toString());
            }
            return "";

        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            Toast.makeText(SendSMS1.this,"SMS Sent",Toast.LENGTH_LONG).show();
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(SendSMS1.this,
                    "ProgressDialog",
                    "Wait for SMS sending");
        }


        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}

