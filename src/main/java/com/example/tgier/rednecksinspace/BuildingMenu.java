package com.example.tgier.rednecksinspace;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.tgier.rednecksinspace.buildings.*;

public class BuildingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_menu);
    }

    public void buildFarmhouse(View view) {
        Button buildFarmhouse = findViewById(R.id.buildFarmhouse);
        if (MainActivity.resources.getMineralResources() >= MainActivity.buildings.get(0).getCost()
                && !MainActivity.buildings.get(0).isItBuilt()
                && !Buildings.isBuildingBuiltThisTurn) {

            MainActivity.resources.setFarmingFactor(((Farmhouse) MainActivity.buildings.get(0)).getFarmingFactorModifier()
                    * MainActivity.resources.getFarmingFactor());
            MainActivity.resources.setMineralResources(MainActivity.resources.getMineralResources()
                    - MainActivity.buildings.get(0).getCost());
            MainActivity.buildings.get(0).setItBuilt(true);
            Buildings.isBuildingBuiltThisTurn = true;
            Toast toast = Toast.makeText(getApplicationContext(), "Farmhouse constructed!", Toast.LENGTH_SHORT);
            toast.show();
            buildFarmhouse.setBackgroundColor(Color.RED);
        } else if (MainActivity.buildings.get(0).isItBuilt()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Farmhouse is already built.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough minerals.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildDeepMine(View view) {
        Button buildDeepMine = findViewById(R.id.buildDeepMine);
        if (MainActivity.resources.getMineralResources() >= MainActivity.buildings.get(1).getCost()
                && !MainActivity.buildings.get(1).isItBuilt()
                && !Buildings.isBuildingBuiltThisTurn) {

            MainActivity.resources.setMineralFactor(((DeepMine) MainActivity.buildings.get(1)).getMineralFactor()
                    * MainActivity.resources.getMineralFactor());
            MainActivity.resources.setMineralResources(MainActivity.resources.getMineralResources()
                    - MainActivity.buildings.get(1).getCost());
            MainActivity.buildings.get(1).setItBuilt(true);
            Buildings.isBuildingBuiltThisTurn = true;
            Toast toast = Toast.makeText(getApplicationContext(), "Deep Mine constructed!", Toast.LENGTH_SHORT);
            toast.show();
            buildDeepMine.setBackgroundColor(Color.RED);
        } else if (MainActivity.buildings.get(1).isItBuilt()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Farmhouse is already built.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough minerals.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildBank(View view) {
        Button buildBank = findViewById(R.id.buildBank);
        if (MainActivity.resources.getMineralResources() >= MainActivity.buildings.get(2).getCost()
                && !MainActivity.buildings.get(2).isItBuilt()
                && !Buildings.isBuildingBuiltThisTurn) {

            MainActivity.resources.setMoneyFactor(((Bank) MainActivity.buildings.get(2)).getMoneyFactor()
                    * MainActivity.resources.getMoneyFactor());
            MainActivity.resources.setMineralResources(MainActivity.resources.getMineralResources()
                    - MainActivity.buildings.get(2).getCost());
            MainActivity.buildings.get(2).setItBuilt(true);
            Buildings.isBuildingBuiltThisTurn = true;
            Toast toast = Toast.makeText(getApplicationContext(), "Bank constructed!", Toast.LENGTH_SHORT);
            toast.show();
            buildBank.setBackgroundColor(Color.RED);
        } else if (MainActivity.buildings.get(2).isItBuilt()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Bank is already built.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough minerals.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildWonderCrane(View view) {
        Button buildWonderCrane = findViewById(R.id.buildWonderCrane);
        if (MainActivity.resources.getMineralResources() >= MainActivity.buildings.get(3).getCost()
                && !MainActivity.buildings.get(3).isItBuilt()
                && !Buildings.isBuildingBuiltThisTurn) {

            MainActivity.wonder.setWonderBuildEfficiency(MainActivity.wonder.getWonderBuildEfficiency()
                    * ((WonderCrane) MainActivity.buildings.get(3)).getWonderBuildEfficiency());
            MainActivity.resources.setMineralResources(MainActivity.resources.getMineralResources()
                    - MainActivity.buildings.get(3).getCost());
            MainActivity.buildings.get(3).setItBuilt(true);
            Buildings.isBuildingBuiltThisTurn = true;
            Toast toast = Toast.makeText(getApplicationContext(), "Wonder Crane constructed!", Toast.LENGTH_SHORT);
            toast.show();
            buildWonderCrane.setBackgroundColor(Color.RED);
        } else if (MainActivity.buildings.get(3).isItBuilt()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Wonder Crane is already built.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough minerals.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildSchool(View view) {
        Button buildSchool = findViewById(R.id.buildSchool);
        if (MainActivity.resources.getMineralResources() >= MainActivity.buildings.get(4).getCost()
                && !MainActivity.buildings.get(4).isItBuilt()
                && !Buildings.isBuildingBuiltThisTurn) {

            MainActivity.resources.setMineralResources(MainActivity.resources.getMineralResources()
                    - MainActivity.buildings.get(4).getCost());
            MainActivity.buildings.get(4).setItBuilt(true);
            Buildings.isBuildingBuiltThisTurn = true;
            Toast toast = Toast.makeText(getApplicationContext(), "School constructed!", Toast.LENGTH_SHORT);
            toast.show();
            buildSchool.setBackgroundColor(Color.RED);
        } else if (MainActivity.buildings.get(4).isItBuilt()) {
            Toast toast = Toast.makeText(getApplicationContext(), "School is already built.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough minerals.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildAlienResourcesReplicator(View view) {
        Button buildAlienResourcesReplicator = findViewById(R.id.buildAlienResourcesReplicator);
        if (MainActivity.resources.getMineralResources() >= MainActivity.buildings.get(5).getCost()
                && !MainActivity.buildings.get(5).isItBuilt()
                && !Buildings.isBuildingBuiltThisTurn) {

            MainActivity.resources.setMineralResources(MainActivity.resources.getMineralResources()
                    - MainActivity.buildings.get(5).getCost());
            MainActivity.buildings.get(5).setItBuilt(true);
            Buildings.isBuildingBuiltThisTurn = true;
            Toast toast = Toast.makeText(getApplicationContext(), "Alien Resources Replicator constructed!", Toast.LENGTH_SHORT);
            toast.show();
            buildAlienResourcesReplicator.setBackgroundColor(Color.RED);
        } else if (MainActivity.buildings.get(5).isItBuilt()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Alien Resources Replicator is already built.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough minerals.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buildAlienBorehole(View view) {
        Button buildAlienBorehole = findViewById(R.id.buildAlienBorehole);
        if (MainActivity.resources.getMineralResources() >= 8 && !buildings.get(6).isItBuilt) {
            resources.setMineralResources(resources.getMineralResources() - 8);
            buildings.get(6).setItBuilt(true);
            isBuildingBuiltThisTurn = true;
            System.out.println("Building constructed.");
        } else if (buildings.get(6).isItBuilt) {
            System.out.println("Alien borehole is already built.");
        } else {
            System.out.println("Not enough resources.");
        }
    }
}
