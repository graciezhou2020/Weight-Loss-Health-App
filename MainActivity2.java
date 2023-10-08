package com.yorku.dietandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public static final String CURRENT_WEIGHT = "com.yorku.dietandfitnessapp.CURRENT_WEIGHT";
    public static final String CURRENT_HEIGHT = "com.yorku.dietandfitnessapp.MAINTAIN_WEIGHT";
    public static final String NEW_HEIGHT = "com.yorku.dietandfitnessapp.GAIN_WEIGHT";

    TextView currentWeight = (TextView) findViewById(R.id.currentWeight);
    String oldWeight = currentWeight.getText().toString();
    int weight = Integer.parseInt(oldWeight);

    TextView currentHeight = (TextView) findViewById(R.id.currentHeight);
    String height = currentHeight.getText().toString();

    TextView goalWeight = (TextView) findViewById(R.id.goalWeight);
    String newWeight = goalWeight.getText().toString();
    int goal = Integer.parseInt(newWeight);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String loseWeight = intent.getStringExtra(com.yorku.dietandfitnessapp.MainActivity.LOSE_WEIGHT);
        String maintainWeight = intent.getStringExtra(com.yorku.dietandfitnessapp.MainActivity.MAINTAIN_WEIGHT);
        String gainWeight = intent.getStringExtra(com.yorku.dietandfitnessapp.MainActivity.GAIN_WEIGHT);

        Button exit = (Button) findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                openExit();
            }
        });

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (view.equals(loseWeight) && weight <= goal){
                    Toast.makeText(MainActivity2.this, "Error! Goal weight cannot be greater than current weight", Toast.LENGTH_SHORT).show();
                }
                else if (view.equals(maintainWeight) && weight != goal){
                    Toast.makeText(MainActivity2.this, "Error! Goal weight must be the same as the current weight", Toast.LENGTH_SHORT).show();
                }
                else if (view.equals(gainWeight) && weight >= goal){
                    Toast.makeText(MainActivity2.this, "Error! Goal weight cannot be less than the current weight", Toast.LENGTH_SHORT).show();
                }
                else{
                    openActivity3();
                }
            }
        });

    }

    public void openExit(){
        Intent intent = new Intent(this, com.yorku.dietandfitnessapp.ActivityExit.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, com.yorku.dietandfitnessapp.MainActivity3.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        intent.putExtra(CURRENT_WEIGHT, oldWeight);
        intent.putExtra(CURRENT_HEIGHT, height);
        intent.putExtra(NEW_HEIGHT, newWeight);
        startActivity(intent);
    }


}