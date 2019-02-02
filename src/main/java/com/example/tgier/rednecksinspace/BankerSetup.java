package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.tgier.rednecksinspace.workers.Banker;
import com.example.tgier.rednecksinspace.workers.Farmer;
import com.example.tgier.rednecksinspace.workers.Miner;
import com.example.tgier.rednecksinspace.workers.Worker;

import java.io.Serializable;

public class BankerSetup extends AppCompatActivity implements Serializable {

    //public static final String WORKER_BANKER = "com.example.tgier.rednecksinspace.BANKER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banker_setup);

        final Worker worker3 = new Banker("Banker", 0, 0, 3, 3
                , 2, false);
        final SeekBar seekBarBankerBrain = findViewById(R.id.seekBarBankerBrain);
        final int bankerBrainPowerSeekBarCorrection = 200;

        int realValueFromPersistentStorage2 = (int) (worker3.getBrainPowerProduction() * 100);
        seekBarBankerBrain.setProgress(realValueFromPersistentStorage2 - bankerBrainPowerSeekBarCorrection);

        final TextView bankersFarmingSkill = findViewById(R.id.bankersFarmingSkill);
        final TextView bankersMiningSkill = findViewById(R.id.bankersMiningSkill);
        final TextView bankersBrainSkill = findViewById(R.id.bankersBrainSkill);
        final TextView bankersFoodReq = findViewById(R.id.bankersFoodReq);
        final TextView bankersWages = findViewById(R.id.bankersWages);
        final Button submitBanker = findViewById(R.id.submitBanker);
        submitBanker.setClickable(false);

        seekBarBankerBrain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public double brainSkill = seekBarBankerBrain.getProgress();


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brainSkill = progress + bankerBrainPowerSeekBarCorrection;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    worker3.setBrainPowerProduction(brainSkill / 100);
                    bankersBrainSkill.setText(String.format("%.2f", brainSkill / 100));
                    double currentFoodProduction = Math.round(Math.sqrt(18 - (Math.pow((brainSkill / 100), 2.0)))*100.0)/100.0;
                    worker3.setFoodProduction(currentFoodProduction);
                    bankersFarmingSkill.setText(String.format("%.2f", currentFoodProduction));
                    double currentMineralProduction = Math.round(Math.sqrt(18 - (Math.pow((brainSkill / 100), 2.0)))*100.0)/100.0;
                    worker3.setMineralProduction(currentMineralProduction);
                    bankersMiningSkill.setText(String.format("%.2f", currentMineralProduction));
                    double currentFoodReq = (0.15 * worker3.getFoodProduction()) + (0.15 * worker3.getMineralProduction())
                            + (0.6 * (brainSkill / 100));
                    worker3.setFoodRequirements(currentFoodReq);
                    bankersFoodReq.setText(String.format("%.2f", currentFoodReq));
                    double currentWages = (0.3 * worker3.getFoodProduction()) + (0.3 * worker3.getMineralProduction())
                            + (0.85 * (brainSkill / 100));
                    worker3.setPayRate(currentWages);
                    bankersWages.setText(String.format("%.2f", currentWages));
                    submitBanker.setClickable(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public void createBanker(View view) {
        Intent intent = new Intent(this, SlaveSetup.class);
        TextView bankersFarmingSkill = findViewById(R.id.bankersFarmingSkill);
        TextView bankersMiningSkill = findViewById(R.id.bankersMiningSkill);
        TextView bankersBrainSkill = findViewById(R.id.bankersBrainSkill);
        TextView bankersFoodReq = findViewById(R.id.bankersFoodReq);
        TextView bankersWages = findViewById(R.id.bankersWages);

        //Intent intent2 = getIntent();
        //Worker worker1 = intent2.getParcelableExtra(WorkerSetup.WORKER_FARMER);
        //Worker worker2 = intent2.getParcelableExtra(MinerSetup.WORKER_MINER);
        Worker worker3 = new Banker("Banker"
                , Double.parseDouble(bankersWages.getText().toString())
                , Double.parseDouble(bankersFoodReq.getText().toString())
                , Double.parseDouble(bankersFarmingSkill.getText().toString())
                , Double.parseDouble(bankersMiningSkill.getText().toString())
                , Double.parseDouble(bankersBrainSkill.getText().toString())
                , false);
        MainActivity.workers.add(2,worker3);
        //intent.putExtra(WORKER_BANKER, worker3);
        //intent.putExtra(WorkerSetup.WORKER_FARMER, worker1);
        //intent.putExtra(MinerSetup.WORKER_MINER, worker2);
        startActivity(intent);
    }
}
