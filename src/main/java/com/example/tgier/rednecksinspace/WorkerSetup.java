package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.tgier.rednecksinspace.workers.Farmer;
import com.example.tgier.rednecksinspace.workers.Worker;

import java.io.Serializable;

public class WorkerSetup extends AppCompatActivity implements Serializable {

    //public static final String WORKER_FARMER = "com.example.tgier.rednecksinspace.FARMER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_setup);

        final Worker worker1 = new Farmer("Farmer", 0, 0, 3, 3
                , 1, false);
        final SeekBar seekBarFarmerFarming = findViewById(R.id.seekBarFarmerFarming);
        final SeekBar seekBarFarmerBrain = findViewById(R.id.seekBarFarmerBrain);
        final int farmerFarmingSeekBarCorrection = 300;
        final int farmerBrainPowerSeekBarCorrection = 100;
        int realValueFromPersistentStorage = (int)(worker1.getFoodProduction() * 100);
        int realValueFromPersistentStorage2 = (int)(worker1.getBrainPowerProduction() * 100);
        seekBarFarmerFarming.setProgress(realValueFromPersistentStorage - farmerFarmingSeekBarCorrection);
        seekBarFarmerBrain.setProgress(realValueFromPersistentStorage2 - farmerBrainPowerSeekBarCorrection);
        final TextView farmerFarmingSkill = findViewById(R.id.farmerFarmingSkill);
        final TextView farmersMineralSkill = findViewById(R.id.farmersMineralSkill);
        final TextView farmerBrainSkill = findViewById(R.id.farmerBrainSkill);
        final TextView farmerFoodReq = findViewById(R.id.farmerFoodReq);
        final TextView farmerWagesReq = findViewById(R.id.farmerWagesReq);
        final Button submitFarmer = findViewById(R.id.submitFarmer);
        submitFarmer.setClickable(false);

        seekBarFarmerFarming.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double farmingSkill = seekBarFarmerFarming.getProgress();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                farmingSkill = (progress + farmerFarmingSeekBarCorrection);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker1.setFoodProduction(farmingSkill / 100);
                    farmerFarmingSkill.setText(String.format("%.2f", farmingSkill / 100));
                    double currentMineralProduction = Math.round(Math.sqrt(19 - ((farmingSkill/100)
                            + Math.pow(worker1.getBrainPowerProduction(), 2.2)))*100.0)/100.0;
                    worker1.setMineralProduction(currentMineralProduction);
                    farmersMineralSkill.setText(String.format("%.2f", currentMineralProduction));
                    double currentFoodReq = (0.2 * (farmingSkill/100)) + (0.3 * worker1.getMineralProduction())
                            + (0.8 * worker1.getBrainPowerProduction());
                    worker1.setFoodRequirements(currentFoodReq);
                    farmerFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = (0.3 * (farmingSkill/100)) + (0.3 * worker1.getMineralProduction())
                            + (0.6 * worker1.getBrainPowerProduction());
                    worker1.setPayRate(currentWages);
                    farmerWagesReq.setText(String.format("%.2f", currentWages));
                    if (worker1.getFoodRequirements() != 0) {
                        submitFarmer.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        seekBarFarmerBrain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            double brainPowerSkill;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brainPowerSkill = (progress + farmerBrainPowerSeekBarCorrection);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker1.setBrainPowerProduction(brainPowerSkill / 100);
                    farmerBrainSkill.setText(String.format("%.2f", brainPowerSkill / 100));
                    double currentMineralProduction = Math.round(Math.sqrt(19 - (worker1.getFoodProduction()
                            + Math.pow((brainPowerSkill/100), 2.2)))*100.0)/100.0;
                    worker1.setMineralProduction(currentMineralProduction);
                    farmersMineralSkill.setText(String.format("%.2f", currentMineralProduction));
                    double currentFoodReq = (0.2 * worker1.getFoodProduction()) + (0.3 * worker1.getMineralProduction())
                            + (0.8 * worker1.getBrainPowerProduction());
                    worker1.setFoodRequirements(currentFoodReq);
                    farmerFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = (0.3 * worker1.getFoodProduction()) + (0.3 * worker1.getMineralProduction())
                            + (0.6 * worker1.getBrainPowerProduction());
                    worker1.setPayRate(currentWages);
                    farmerWagesReq.setText(String.format("%.2f", currentWages));
                    if (worker1.getFoodRequirements() != 0) {
                        submitFarmer.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void createFarmer(View view) {
        Intent intent = new Intent(this, MinerSetup.class);
        TextView farmerFarmingSkill = findViewById(R.id.farmerFarmingSkill);
        TextView farmersMineralSkill = findViewById(R.id.farmersMineralSkill);
        TextView farmerBrainSkill = findViewById(R.id.farmerBrainSkill);
        TextView farmerFoodReq = findViewById(R.id.farmerFoodReq);
        TextView farmerWagesReq = findViewById(R.id.farmerWagesReq);
        Worker worker1 = new Farmer("Farmer"
                , Double.parseDouble(farmerWagesReq.getText().toString())
                , Double.parseDouble(farmerFoodReq.getText().toString())
                , Double.parseDouble(farmerFarmingSkill.getText().toString())
                , Double.parseDouble(farmersMineralSkill.getText().toString())
                , Double.parseDouble(farmerBrainSkill.getText().toString())
                , false);
        MainActivity.workers.add(0, worker1);
        //intent.putExtra(WORKER_FARMER, worker1);
        startActivity(intent);

    }
}
