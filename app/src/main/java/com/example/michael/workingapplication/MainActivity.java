package com.example.michael.workingapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    //Declaring instance of FirebaseAuth
    private FirebaseAuth mAuth;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the Firebase Auth instance
        mAuth = FirebaseAuth.getInstance();

        //If already singed in start math activity
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
        }

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextUser = findViewById(R.id.editTextUser);
                EditText editTextPass = findViewById(R.id.editTextPass);

                //intent to sign in
                try {
                    String email = editTextUser.getText().toString();
                    String password = editTextPass.getText().toString();
                    loginUser(email, password);
                }catch(IllegalArgumentException e){
                    Toast.makeText(MainActivity.this, "Enter email and password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void loginUser(String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
}