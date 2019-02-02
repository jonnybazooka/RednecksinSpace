package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.tgier.rednecksinspace.workers.Farmer;
import com.example.tgier.rednecksinspace.workers.Miner;
import com.example.tgier.rednecksinspace.workers.Worker;

import java.io.Serializable;

public class MinerSetup extends AppCompatActivity implements Serializable {

    //public static final String WORKER_MINER = "com.example.tgier.rednecksinspace.MINER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miner_setup);

        final Worker worker2 = new Miner("Miner", 0, 0, 3, 3
                , 1, false);
        final SeekBar seekBarMinerMining = findViewById(R.id.seekBarMinerMining);
        final SeekBar seekBarMinerBrain = findViewById(R.id.seekBarMinerBrain);
        final int minerMiningSeekBarCorrection = 300;
        final int minerBrainPowerSeekBarCorrection = 100;

        int realValueFromPersistentStorage = (int)(worker2.getMineralProduction() * 100);
        int realValueFromPersistentStorage2 = (int)(worker2.getBrainPowerProduction() * 100);
        seekBarMinerMining.setProgress(realValueFromPersistentStorage - minerMiningSeekBarCorrection);
        seekBarMinerBrain.setProgress(realValueFromPersistentStorage2 - minerBrainPowerSeekBarCorrection);

        final TextView minerFarmingSkill = findViewById(R.id.minerFarmingSkill);
        final TextView minersMiningSkill = findViewById(R.id.minersMiningSkill);
        final TextView minersBrainSkill = findViewById(R.id.minersBrainSkill);
        final TextView minersFoodReq = findViewById(R.id.minersFoodReq);
        final TextView minersWages = findViewById(R.id.minersWages);
        final Button submitMiner = findViewById(R.id.submitMiner);
        submitMiner.setClickable(false);

        seekBarMinerMining.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double miningSkill = seekBarMinerMining.getProgress();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                miningSkill = progress + minerMiningSeekBarCorrection;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker2.setMineralProduction(miningSkill / 100);
                    minersMiningSkill.setText(String.format("%.2f", miningSkill / 100));
                    double currentFoodProduction = Math.round(Math.sqrt(18 - ((miningSkill / 100)
                            + Math.pow(worker2.getBrainPowerProduction(), 2.1)))*100.0)/100.0;
                    worker2.setFoodProduction(currentFoodProduction);
                    minerFarmingSkill.setText(String.format("%.2f", currentFoodProduction));
                    double currentFoodReq = (0.25 * worker2.getFoodProduction()) + (0.45 * (miningSkill/100))
                            + (0.6 * worker2.getBrainPowerProduction());
                    worker2.setFoodRequirements(currentFoodProduction);
                    minersFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = (0.3 * worker2.getFoodProduction()) + (0.2 * (miningSkill/100))
                            + (0.6 * worker2.getBrainPowerProduction());
                    worker2.setPayRate(currentWages);
                    minersWages.setText(String.format("%.2f", currentWages));
                    if (worker2.getFoodRequirements() != 0) {
                        submitMiner.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        seekBarMinerBrain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double brainSkill = seekBarMinerBrain.getProgress();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brainSkill = progress + minerBrainPowerSeekBarCorrection;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker2.setBrainPowerProduction(brainSkill / 100);
                    minersBrainSkill.setText(String.format("%.2f", brainSkill / 100));
                    double currentFoodProduction = Math.round(Math.sqrt(18 - (worker2.getMineralProduction()
                            + Math.pow((brainSkill / 100), 2.1)))*100.0)/100.0;
                    worker2.setFoodProduction(currentFoodProduction);
                    minerFarmingSkill.setText(String.format("%.2f", currentFoodProduction));
                    double currentFoodReq = (0.25 * worker2.getFoodProduction()) + (0.45 * worker2.getMineralProduction())
                            + (0.6 * (brainSkill / 100));
                    worker2.setFoodRequirements(currentFoodProduction);
                    minersFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = (0.3 * worker2.getFoodProduction()) + (0.2 * worker2.getMineralProduction())
                            + (0.6 * (brainSkill / 100));
                    worker2.setPayRate(currentWages);
                    minersWages.setText(String.format("%.2f", currentWages));
                    if (worker2.getFoodRequirements() != 0) {
                        submitMiner.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void createMiner(View view) {
        Intent intent = new Intent(this, BankerSetup.class);
        TextView minerFarmingSkill = findViewById(R.id.minerFarmingSkill);
        TextView minersMiningSkill = findViewById(R.id.minersMiningSkill);
        TextView minersBrainSkill = findViewById(R.id.minersBrainSkill);
        TextView minersFoodReq = findViewById(R.id.minersFoodReq);
        TextView minersWages = findViewById(R.id.minersWages);
        //Intent intent2 = getIntent();
        //Worker worker1 = intent2.getParcelableExtra(WorkerSetup.WORKER_FARMER);
        Worker worker2 = new Farmer("Miner"
                , Double.parseDouble(minersWages.getText().toString())
                , Double.parseDouble(minersFoodReq.getText().toString())
                , Double.parseDouble(minerFarmingSkill.getText().toString())
                , Double.parseDouble(minersMiningSkill.getText().toString())
                , Double.parseDouble(minersBrainSkill.getText().toString())
                , false);
        MainActivity.workers.add(1, worker2);
        //intent.putExtra(WORKER_MINER, worker2);
        //intent.putExtra(WorkerSetup.WORKER_FARMER, worker1);
        startActivity(intent);

    }
}
