package com.example.michael.workingapplication;

import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Variables for the database switch reference and app switch
        final DatabaseReference switch1Ref = database.getReference("Switch1");
        final Switch switch1 = findViewById(R.id.switch1);

        // On click listener for app switch, sets data base switch ref to true or false
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean value = switch1.isChecked();
                switch1Ref.setValue(value);
            }
        });

        // SWITCH1
        // Reads switch value from the database
        switch1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d(TAG, "Value is: " + value);

                // try to set app switch to value from database
                try{
                    switch1.setChecked(value);
                }catch(Exception e){
                    Log.d(TAG, "exception caught trying to set boolean for switch");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // SWITCH 2
        // Variables for the database switch reference and app switch
        final DatabaseReference switch2Ref = database.getReference("Switch2");
        final Switch switch2 = findViewById(R.id.switch2);

        // On click listener for app switch, sets data base switch ref to true or false
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean value = switch2.isChecked();
                switch2Ref.setValue(value);
            }
        });

        // Reads switch value from the database
        switch2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d(TAG, "Value is: " + value);

                // try to set app switch to value from database
                try{
                    switch2.setChecked(value);
                }catch(Exception e){
                    Log.d(TAG, "exception caught trying to set boolean for switch");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // SWITCH 3
        // Variables for the database switch reference and app switch
        final DatabaseReference switch3Ref = database.getReference("Switch3");
        final Switch switch3 = findViewById(R.id.switch3);

        // On click listener for app switch, sets data base switch ref to true or false
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean value = switch3.isChecked();
                switch3Ref.setValue(value);
            }
        });

        // Reads switch value from the database
        switch3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d(TAG, "Value is: " + value);

                // try to set app switch to value from database
                try{
                    switch3.setChecked(value);
                }catch(Exception e){
                    Log.d(TAG, "exception caught trying to set boolean for switch");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // SWITCH 4
        // Variables for the database switch reference and app switch
        final DatabaseReference switch4Ref = database.getReference("Switch4");
        final Switch switch4 = findViewById(R.id.switch4);

        // On click listener for app switch, sets data base switch ref to true or false
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean value = switch4.isChecked();
                switch4Ref.setValue(value);
            }
        });

        // Reads switch value from the database
        switch4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d(TAG, "Value is: " + value);

                // try to set app switch to value from database
                try{
                    switch4.setChecked(value);
                }catch(Exception e){
                    Log.d(TAG, "exception caught trying to set boolean for switch");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
}
