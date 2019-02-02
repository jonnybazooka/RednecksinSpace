package com.example.tgier.rednecksinspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_resources);

        TextView showFoodText = findViewById(R.id.showFoodText);
        TextView showMineralsText = findViewById(R.id.showMineralsText);
        TextView showMoneyText = findViewById(R.id.showMoneyText);

        showFoodText.setText(String.format("%.2f", MainActivity.resources.getFoodResources()));
        showMineralsText.setText(String.format("%.2f", MainActivity.resources.getMineralResources()));
        showMoneyText.setText(String.format("%.2f", MainActivity.resources.getMoneyResources()));
    }
}
