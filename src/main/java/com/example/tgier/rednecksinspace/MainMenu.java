package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.tgier.rednecksinspace.aplicationCore.Wonder;
import com.example.tgier.rednecksinspace.buildings.Buildings;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button showWorkers = findViewById(R.id.showWorkers);
        final Button showResources = findViewById(R.id.showResources);
        final Button buildWonder = findViewById(R.id.buildWonder);
        if (MainActivity.wonder.isWonderBuiltThisTurn()) {
            buildWonder.setBackgroundColor(Color.RED);
        }
        final Button buildBuilding = findViewById(R.id.buildBuilding);
        if (Buildings.isBuildingBuiltThisTurn) {
            buildBuilding.setBackgroundColor(Color.RED);
        }

    }

    public void showWorkers(View view) {
        Button showWorkers = findViewById(R.id.showWorkers);
        Intent intent = new Intent(this, ShowWorkers.class);
        startActivity(intent);
    }

    public void showResources(View view) {
        Button showResources = findViewById(R.id.showResources);
        Intent intent = new Intent(this, ShowResources.class);
        startActivity(intent);
    }

    public void buildWonder(View view) {
        Button buildWonder = findViewById(R.id.buildWonder);
        if (MainActivity.resources.getMineralResources() >= 5) {
            MainActivity.wonder.constructWonder(MainActivity.resources);
            Toast toast = Toast.makeText(getApplicationContext()
                    , "Wonder progress: " + MainActivity.wonder.getWonderConstructionProgress() + " / 50"
                    , Toast.LENGTH_SHORT);
            toast.show();
            buildWonder.setClickable(false);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough resources", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildBuilding(View view) {
        Intent intent = new Intent(this, BuildingMenu.class);
        startActivity(intent);
    }
}
