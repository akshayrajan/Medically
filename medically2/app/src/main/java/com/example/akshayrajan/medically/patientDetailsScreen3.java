package com.example.akshayrajan.medically;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class patientDetailsScreen3 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details_screen3);
        button = (Button) findViewById(R.id.buttonlocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 18.5415649, 73.8115532);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);


                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=loc:" + 18.5415649 + "," + 73.8115532));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Only if initiating from a Broadcast Receiver
                String mapsPackageName = "com.google.android.apps.maps";
                    i.setClassName(mapsPackageName, "com.google.android.maps.MapsActivity");
                    i.setPackage(mapsPackageName);
                startActivity(i);

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        String email = i.getStringExtra("email");
        int length = i.getIntExtra("length",0);
        String cause[] = new String[100];
        String date[] = new String[100];
        String notes[] = new String[100];
        String medicine[] = new String[100];
        String Details = i.getStringExtra("Details");
        for(int v = 0; v<length; v++)
        {
            cause[v] =i.getStringExtra("cause"+v);
            date[v] = i.getStringExtra("date"+v);
            notes[v] =i.getStringExtra("notes"+v);
            medicine[v] =i.getStringExtra("medicine"+v);

        }
        mTextView = (TextView) findViewById(R.id.textViewPatient);
        StringBuilder result = new StringBuilder();
        for(int v = 0; v<length; v++)
        {
            result.append("Prescription Number "+v+"\n");
            result.append("Cause "+cause[v]+"\n");
            result.append("Date "+date[v]+"\n");
            result.append("Notes "+notes[v]+"\n");
            result.append("Medicine "+medicine[v]+"\n\n");
        }
            String res = result.toString();
            mTextView.setText(Details);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.patient_details_screen3, menu);
//        return true;
//    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.prescription) {
            Intent i = new Intent(getApplicationContext(), daterangeofmedicines.class);
            startActivity(i);
        } else if (id == R.id.track_order) {
            Intent i = new Intent(getApplicationContext(), trackorder.class);
            startActivity(i);

        } else if (id == R.id.change_password) {
            Intent i = new Intent(getApplicationContext(), passwordchange.class);
            startActivity(i);

        } else if (id == R.id.logout) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        } else if (id == R.id.searchformedicine) {
            Intent i = new Intent(getApplicationContext(), searchformedicine.class);
            startActivity(i);

        }
        else if (id == R.id.getappointment) {
            Intent i = new Intent(getApplicationContext(), GetAppoinment.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void collectPhoneNumbers(Map<String,Object> users) {

        ArrayList<String> phoneNumbers = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            phoneNumbers.add((String) singleUser.get("PrescriptionID"));
        }
        Log.v("321Printing",phoneNumbers.toString());
    }
}
