package com.yorku.dietandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    public static final String LEVEL_EASY = "com.yorku.dietandfitnessapp.LEVEL_EASY";
    public static final String LEVEL_MEDIUM = "com.yorku.dietandfitnessapp.LEVEL_MEDIUM";
    public static final String LEVEL_HARD = "com.yorku.dietandfitnessapp.LEVEL_HARD";

    RadioButton easy = (RadioButton) findViewById(R.id.easy);
    String level1 = easy.toString();
    RadioButton medium = (RadioButton) findViewById(R.id.medium);
    String level2 = medium.toString();
    RadioButton hard = (RadioButton) findViewById(R.id.hard);
    String level3 = hard.toString();
    Button exit = (Button) findViewById(R.id.exit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();
        String loseWeight = bundle.getString("LOSE_WEIGHT");
        String maintainWeight = bundle.getString("MAINTAIN_WEIGHT");
        String gainWeight = bundle.getString("GAIN_WEIGHT");
        String currentWeight = bundle.getString("CURRENT_WEIGHT");
        String currentHeight = bundle.getString("CURRENT_HEIGHT");
        String newWeight = bundle.getString("NEW_WEIGHT");

        easy.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                openActivity4();
            }
        });

        medium.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                openActivity4();
            }
        });

        hard.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                openActivity4();
            }
        });

        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                openExit();
            }
        });

    }

    public void openActivity4(){
        Intent intent = new Intent (this, MainActivity4.class);
        intent.putExtra(LEVEL_EASY, level1);
        intent.putExtra(LEVEL_MEDIUM, level2);
        intent.putExtra(LEVEL_HARD, level3);
        startActivity(intent);
    }

    public void openExit(){
        Intent intent = new Intent(this, ActivityExit.class);
        startActivity(intent);
    }
}