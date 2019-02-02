package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.tgier.rednecksinspace.aplicationCore.Resources;
import com.example.tgier.rednecksinspace.workers.Worker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class DifficultySetup extends AppCompatActivity implements Serializable {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_setup);

        //Intent intent2 = getIntent();
        //workers = intent2.getParcelableExtra(SlaveSetup.WORKERS_LIST);

        /*final RadioGroup difficultySelectionButtons = findViewById(R.id.difficultySelectionButtons);
        final RadioButton difficultyEasyButton = findViewById(R.id.difficultyEasyButton);
        final RadioButton difficultyMediumButton = findViewById(R.id.difficultyMediumButton);
        final RadioButton difficultyHardButton = findViewById(R.id.difficultyHardButton);
        final Button confirmDifficultyButton = findViewById(R.id.confirmDifficultyButton);*/
    }

    public void setDifficulty(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        RadioGroup difficultySelectionButtons = findViewById(R.id.difficultySelectionButtons);
        RadioButton difficultyEasyButton = findViewById(R.id.difficultyEasyButton);
        RadioButton difficultyMediumButton = findViewById(R.id.difficultyMediumButton);
        RadioButton difficultyHardButton = findViewById(R.id.difficultyHardButton);
        Button confirmDifficultyButton = findViewById(R.id.confirmDifficultyButton);

        if (difficultyEasyButton.isChecked()) {
            MainActivity.resources.setFoodResources(30);
            MainActivity.resources.setMineralResources(30);
            MainActivity.resources.setMoneyResources(30);
        }  else if (difficultyHardButton.isChecked()) {
            MainActivity.resources.setFoodResources(20);
            MainActivity.resources.setMineralResources(20);
            MainActivity.resources.setMoneyResources(20);
        }
        startActivity(intent);
    }


}
