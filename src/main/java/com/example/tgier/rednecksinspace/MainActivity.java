package com.example.tgier.rednecksinspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.tgier.rednecksinspace.aplicationCore.Resources;
import com.example.tgier.rednecksinspace.aplicationCore.Wonder;
import com.example.tgier.rednecksinspace.buildings.Buildings;
import com.example.tgier.rednecksinspace.crises.Crisis;
import com.example.tgier.rednecksinspace.workers.Worker;

import java.util.ArrayList;

import static com.example.tgier.rednecksinspace.aplicationCore.App.buildingsSetup;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Worker> workers = new ArrayList<>();
    public static Resources resources = new Resources(25, 25
            , 25, 1, 1, 2, false);
    public static Wonder wonder = new Wonder(0, 1, false);
    public static ArrayList<Buildings> buildings = buildingsSetup();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewGame(View view) {
        Intent intent = new Intent(this, WorkerSetup.class);
        startActivity(intent);
    }
}
