package com.yorku.dietandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String LOSE_WEIGHT = "com.yorku.dietandfitnessapp.LOSE_WEIGHT";
    public static final String MAINTAIN_WEIGHT = "com.yorku.dietandfitnessapp.MAINTAIN_WEIGHT";
    public static final String GAIN_WEIGHT = "com.yorku.dietandfitnessapp.GAIN_WEIGHT";

    RadioButton loseWeight = findViewById(R.id.loseweight);
    String less = loseWeight.toString();

    RadioButton maintainWeight = findViewById(R.id.maintainweight);
    String same = maintainWeight.toString();

    RadioButton gainWeight = findViewById(R.id.gainweight);
    String more = gainWeight.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loseWeight.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                openActivity2();
            }

        });

        maintainWeight.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                openActivity2();
            }

        });

        gainWeight.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                openActivity2();
            }

        });

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                openExit();
            }
        });
    }
        public void openActivity2(){
            Intent intent = new Intent (this, MainActivity2.class);
            intent.putExtra(LOSE_WEIGHT, less);
            intent.putExtra(MAINTAIN_WEIGHT, same);
            intent.putExtra(GAIN_WEIGHT, more);
            startActivity(intent);
        }

        public void openExit(){
        Intent intent = new Intent (this, ActivityExit.class);
        startActivity(intent);
        }

}
