package com.example.michael.workingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare add button and set listener
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize variables to xml objects
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                //if editText(s) do not contain integers, catch
                try {
                    //parse the variables to get the integer
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());

                    //add the two integers and return the result
                    int result = num1 + num2;
                    resultTextView.setText(num1 + " + " + num2 + " = " + result + "");

                } catch (NumberFormatException e) {
                    resultTextView.setText("How about typing some numbers?");
                }

            }
        });

        //declare add button and set listener
        Button multButton = (Button) findViewById(R.id.multButton);
        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize variables to xml objects
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                //if editText(s) do not contain integers, catch
                try {
                    //parse the variables to get the integer
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());

                    //multiply the two integers and return the result
                    int result = num1 * num2;
                    resultTextView.setText(num1 + " * " + num2 + " = " + result + "");

                } catch (NumberFormatException e) {
                    resultTextView.setText("How about typing some numbers?");
                }
            }
        });


    }
}
