package com.example.tgier.rednecksinspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowWorkers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_workers);

        TextView farmersFarmingText = findViewById(R.id.farmersFarmingText);
        TextView farmersMiningText = findViewById(R.id.farmersMiningText);
        TextView farmersBrainText = findViewById(R.id.farmersBrainText);
        TextView farmersFoodReqText = findViewById(R.id.farmersFoodReqText);
        TextView farmersWagesText = findViewById(R.id.farmersWagesText);

        TextView minersFarmingText = findViewById(R.id.minersFarmingText);
        TextView minersMiningText = findViewById(R.id.minersMiningText);
        TextView minersBrainText = findViewById(R.id.minersBrainText);
        TextView minersFoodReqText = findViewById(R.id.minersFoodReqText);
        TextView minersWagesText = findViewById(R.id.minersWagesText);

        TextView bankersFarmingText = findViewById(R.id.bankersFarmingText);
        TextView bankersMiningText = findViewById(R.id.bankersMiningText);
        TextView bankersBrainText = findViewById(R.id.bankersBrainText);
        TextView bankersFoodReqText = findViewById(R.id.bankersFoodReqText);
        TextView bankersWagesText = findViewById(R.id.bankersWagesText);

        TextView slavesFarmingText = findViewById(R.id.slavesFarmingText);
        TextView slavesMiningText = findViewById(R.id.slavesMiningText);
        TextView slavesBrainText = findViewById(R.id.slavesBrainText);
        TextView slavesFoodReqText = findViewById(R.id.slavesFoodReqText);
        TextView slavesWagesText = findViewById(R.id.slavesWagesText);

        farmersFarmingText.setText(String.format("%.2f", MainActivity.workers.get(0).getFoodProduction()));
        farmersMiningText.setText(String.format("%.2f", MainActivity.workers.get(0).getMineralProduction()));
        farmersBrainText.setText(String.format("%.2f", MainActivity.workers.get(0).getBrainPowerProduction()));
        farmersFoodReqText.setText(String.format("%.2f", MainActivity.workers.get(0).getFoodRequirements()));
        farmersWagesText.setText(String.format("%.2f", MainActivity.workers.get(0).getPayRate()));

        minersFarmingText.setText(String.format("%.2f", MainActivity.workers.get(1).getFoodProduction()));
        minersMiningText.setText(String.format("%.2f", MainActivity.workers.get(1).getMineralProduction()));
        minersBrainText.setText(String.format("%.2f", MainActivity.workers.get(1).getBrainPowerProduction()));
        minersFoodReqText.setText(String.format("%.2f", MainActivity.workers.get(1).getFoodRequirements()));
        minersWagesText.setText(String.format("%.2f", MainActivity.workers.get(1).getPayRate()));

        bankersFarmingText.setText(String.format("%.2f", MainActivity.workers.get(2).getFoodProduction()));
        bankersMiningText.setText(String.format("%.2f", MainActivity.workers.get(2).getMineralProduction()));
        bankersBrainText.setText(String.format("%.2f", MainActivity.workers.get(2).getBrainPowerProduction()));
        bankersFoodReqText.setText(String.format("%.2f", MainActivity.workers.get(2).getFoodRequirements()));
        bankersWagesText.setText(String.format("%.2f", MainActivity.workers.get(2).getPayRate()));

        slavesFarmingText.setText(String.format("%.2f", MainActivity.workers.get(3).getFoodProduction()));
        slavesMiningText.setText(String.format("%.2f", MainActivity.workers.get(3).getMineralProduction()));
        slavesBrainText.setText(String.format("%.2f", MainActivity.workers.get(3).getBrainPowerProduction()));
        slavesFoodReqText.setText(String.format("%.2f", MainActivity.workers.get(3).getFoodRequirements()));
        slavesWagesText.setText(String.format("%.2f", MainActivity.workers.get(3).getPayRate()));


    }
}
