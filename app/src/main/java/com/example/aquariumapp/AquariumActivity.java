package com.example.aquariumapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.aquariumapp.Model.Aquarium;
import com.example.aquariumapp.Network.NetworkManager;
import com.example.aquariumapp.UI.AquariumContract;
import com.example.aquariumapp.UI.AquariumPresenterImpl;

public class AquariumActivity extends AppCompatActivity implements AquariumContract.View {

    private AquariumContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquarium);
        presenter = new AquariumPresenterImpl(this,new NetworkManager());
        presenter.getData();
    }

    public void updateData(View view){
        presenter.getData();
    }

    @Override
    public void update(Aquarium aquarium) {
        TextView temperature = findViewById(R.id.temperatureText);
        TextView waterLevel = findViewById(R.id.waterLevelText);

        temperature.setText("Temperature: " + aquarium.getTemperature());
        waterLevel.setText("Water Level: " + aquarium.getWaterLevel());
    }
}
