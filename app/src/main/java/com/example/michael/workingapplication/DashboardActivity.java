package com.example.michael.workingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //new math activity button
        ImageButton mathActivityButton = (ImageButton) findViewById(R.id.imageButtonMath);
        mathActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start intent to start new activity
                Intent startIntent = new Intent(getApplicationContext(), MathActivity.class);
                startActivity(startIntent);
            }
        });

        ImageButton dataActivityButton = (ImageButton) findViewById(R.id.imageButtonData);
        dataActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start intent to start new activity
                Intent startIntent = new Intent(getApplicationContext(), DatabaseActivity.class);
                startActivity(startIntent);
            }
        });

        //Sign out button
        Button signOutBtn = findViewById(R.id.btnSignOut);
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //signs user out and closes current activity
                FirebaseAuth.getInstance().signOut();
                finish();
                Toast.makeText(DashboardActivity.this, "Signed Out",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Get current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //Display User on top right TextView field
        if (user != null) {
            String userName = user.getEmail();
            TextView textViewUserName = findViewById(R.id.textViewUserName);
            textViewUserName.setText(userName);
        }
    }
}
