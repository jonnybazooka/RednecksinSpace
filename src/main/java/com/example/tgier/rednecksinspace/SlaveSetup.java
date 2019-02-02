package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.tgier.rednecksinspace.workers.Banker;
import com.example.tgier.rednecksinspace.workers.Slave;
import com.example.tgier.rednecksinspace.workers.Worker;

import java.io.Serializable;
import java.util.ArrayList;

public class SlaveSetup extends AppCompatActivity implements Serializable {

    //public static final String WORKERS_LIST = "com.example.tgier.rednecksinspace.WORKERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slave_setup);

        final Worker worker4 = new Slave("Slave", 0, 0, 2, 2
                , 1, false);
        final SeekBar seekBarSlaveFarming = findViewById(R.id.seekBarSlaveFarming);
        final SeekBar seekBarSlaveMining = findViewById(R.id.seekBarSlaveMining);
        final SeekBar seekBarSlaveBrain = findViewById(R.id.seekBarSlaveBrain);
        final int slaveFarmingSeekBarCorrection = 200;
        final int slaveMiningSeekBarCorrection = 200;
        final int slaveBrainPowerSeekBarCorrection = 100;

        int realValueFromPersistentStorage1 = (int) (worker4.getFoodProduction() * 100);
        int realValueFromPersistentStorage2 = (int) (worker4.getMineralProduction() * 100);
        int realValueFromPersistentStorage3 = (int) (worker4.getBrainPowerProduction() * 100);
        seekBarSlaveFarming.setProgress(realValueFromPersistentStorage1 - slaveFarmingSeekBarCorrection);
        seekBarSlaveMining.setProgress(realValueFromPersistentStorage2 - slaveMiningSeekBarCorrection);
        seekBarSlaveBrain.setProgress(realValueFromPersistentStorage3 - slaveBrainPowerSeekBarCorrection);

        final TextView slavesFarmingSkill = findViewById(R.id.slavesFarmingSkill);
        final TextView slavesMiningSkill = findViewById(R.id.slavesMiningSkill);
        final TextView slavesBrainSkill = findViewById(R.id.slavesBrainSkill);
        final TextView slavesFoodReq = findViewById(R.id.slavesFoodReq);
        final TextView slavesWages = findViewById(R.id.slavesWages);
        final Button submitSlave = findViewById(R.id.submitSlave);
        submitSlave.setClickable(false);

        seekBarSlaveFarming.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double farmingSkill = seekBarSlaveFarming.getProgress();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                farmingSkill = progress + slaveFarmingSeekBarCorrection;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker4.setFoodProduction(farmingSkill/100);
                    slavesFarmingSkill.setText(String.format("%.2f", (farmingSkill/100)));
                    double currentFoodReq = 0.15 * Math.round((Math.pow(worker4.getFoodProduction(), 2)
                            + 0.15 * Math.pow(worker4.getMineralProduction(), 2)
                            + 0.4 * Math.pow(worker4.getBrainPowerProduction(), 2))*100.0)/100.0;
                    worker4.setFoodRequirements(currentFoodReq);
                    slavesFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = 0.1 * worker4.getFoodProduction()
                            + 0.1 * worker4.getMineralProduction()
                            + 0.3 * worker4.getBrainPowerProduction();
                    worker4.setPayRate(currentWages);
                    slavesWages.setText(String.format("%.2f", currentWages));
                    if (worker4.getFoodRequirements() != 0) {
                        submitSlave.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        seekBarSlaveMining.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double miningSkill = seekBarSlaveMining.getProgress();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                miningSkill = progress + slaveMiningSeekBarCorrection;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker4.setMineralProduction(miningSkill/100);
                    slavesMiningSkill.setText(String.format("%.2f", (miningSkill/100)));
                    double currentFoodReq = 0.15 * Math.round((Math.pow(worker4.getFoodProduction(), 2)
                            + 0.15 * Math.pow(worker4.getMineralProduction(), 2)
                            + 0.4 * Math.pow(worker4.getBrainPowerProduction(), 2))*100.0)/100.0;
                    worker4.setFoodRequirements(currentFoodReq);
                    slavesFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = 0.1 * worker4.getFoodProduction()
                            + 0.1 * worker4.getMineralProduction()
                            + 0.3 * worker4.getBrainPowerProduction();
                    worker4.setPayRate(currentWages);
                    slavesWages.setText(String.format("%.2f", currentWages));
                    if (worker4.getFoodRequirements() != 0) {
                        submitSlave.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        seekBarSlaveBrain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double brainSkill = seekBarSlaveBrain.getProgress();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brainSkill = progress + slaveBrainPowerSeekBarCorrection;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker4.setBrainPowerProduction(brainSkill/100);
                    slavesBrainSkill.setText(String.format("%.2f", (brainSkill/100)));
                    double currentFoodReq = 0.15 * Math.round((Math.pow(worker4.getFoodProduction(), 2)
                            + 0.15 * Math.pow(worker4.getMineralProduction(), 2)
                            + 0.4 * Math.pow(worker4.getBrainPowerProduction(), 2))*100.0)/100.0;
                    worker4.setFoodRequirements(currentFoodReq);
                    slavesFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = 0.1 * worker4.getFoodProduction()
                            + 0.1 * worker4.getMineralProduction()
                            + 0.3 * worker4.getBrainPowerProduction();
                    worker4.setPayRate(currentWages);
                    slavesWages.setText(String.format("%.2f", currentWages));
                    if (worker4.getFoodRequirements() != 0) {
                        submitSlave.setClickable(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void createSlave(View view) {
        Intent intent = new Intent(this, DifficultySetup.class);
        TextView slavesFarmingSkill = findViewById(R.id.slavesFarmingSkill);
        TextView slavesMiningSkill = findViewById(R.id.slavesMiningSkill);
        TextView slavesBrainSkill = findViewById(R.id.slavesBrainSkill);
        TextView slavesFoodReq = findViewById(R.id.slavesFoodReq);
        TextView slavesWages = findViewById(R.id.slavesWages);

        //Intent intent2 = getIntent();
        //Worker worker1 = intent2.getParcelableExtra(WorkerSetup.WORKER_FARMER);
        //Worker worker2 = intent2.getParcelableExtra(MinerSetup.WORKER_MINER);
        //Worker worker3 = intent2.getParcelableExtra(BankerSetup.WORKER_BANKER);
        Worker worker4 = new Slave("Slave"
                , Double.parseDouble(slavesWages.getText().toString())
                , Double.parseDouble(slavesFoodReq.getText().toString())
                , Double.parseDouble(slavesFarmingSkill.getText().toString())
                , Double.parseDouble(slavesMiningSkill.getText().toString())
                , Double.parseDouble(slavesBrainSkill.getText().toString())
                , false);
        MainActivity.workers.add(3,worker4);
        //ArrayList<Worker> workers = new ArrayList<>();
        //workers.add(0, worker1);
        //workers.add(1, worker2);
        //workers.add(2, worker3);
        //workers.add(3, worker4);
        //intent.putExtra(WORKERS_LIST, workers);
        startActivity(intent);
    }
}
