package com.yorku.dietandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Bundle bundle = getIntent().getExtras();
        String weight = bundle.getString("CURRENT_WEIGHT");
        String height = bundle.getString("CURRENT_HEIGHT");
        String newWeight = bundle.getString("NEW_WEIGHT");
        String goal1 = bundle.getString("LOSE_WEIGHT");
        String goal2 = bundle.getString("MAINTAIN_WEIGHT");
        String goal3 = bundle.getString("GAIN_WEIGHT");
        String level1 = bundle.getString("LEVEL_EASY");
        String level2 = bundle.getString("LEVEL_MEDIUM");
        String level3 = bundle.getString("LEVEL_HARD");


        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView image = (ImageView) findViewById(R.id.imageView1);
                if(Integer.parseInt(weight)>=Integer.parseInt(newWeight)){
                    if(view.equals(level1)){
                        image.setImageResource(R.drawable.lose_weight_easy);
                    }else if(view.equals(level2)){
                        image.setImageResource(R.drawable.lose_weight_medium);
                    }else if(view.equals(level3)){
                        image.setImageResource(R.drawable.lose_weight_hard);
                    }
                }else if (Integer.parseInt(weight) == Integer.parseInt(newWeight)){
                        image.setImageResource(R.drawable.maintain_weight);
                } else if (Integer.parseInt(weight) <= Integer.parseInt(newWeight)){
                    if(view.equals(level1)){
                        image.setImageResource(R.drawable.gain_weight_easy);
                    }else if(view.equals(level2)){
                        image.setImageResource(R.drawable.gain_weight_medium);
                    }else if(view.equals(level3)){
                        image.setImageResource(R.drawable.gain_weight_hard);
                    }
                }

                openExit();
            }
        });

    }

    public void openExit(){
        Intent intent = new Intent(this, ActivityExit.class);
        startActivity(intent);
    }
}

