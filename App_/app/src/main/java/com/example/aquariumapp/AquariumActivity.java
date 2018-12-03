package com.example.aquariumapp;

import android.graphics.Color;
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
    }

    public void updateData(View view){
        presenter.getData();
    }

    @Override
    public void update(Aquarium aquarium) {
        TextView temperature = findViewById(R.id.temperatureText);
        TextView waterLevel = findViewById(R.id.waterLevelText);
        TextView overflowLevel = findViewById(R.id.overflowLevelText);

        temperature.setText("Temperature: " + aquarium.getTemperature());
        waterLevel.setText("Water Level: " + aquarium.getWaterLevel());
        overflowLevel.setText("Overflow Level: " + aquarium.getOverflowLevel());

        String ovrflowValue = aquarium.getOverflowLevel();
        int ovrflowresult = Integer.parseInt(ovrflowValue);
        if(ovrflowresult >= 2){
            overflowLevel.setTextColor(Color.RED);
        }


        String waterlvlValue = aquarium.getWaterLevel();
        int waterlvlResult = Integer.parseInt(waterlvlValue);
        if(waterlvlResult <= 2){
            waterLevel.setTextColor(Color.RED);

        }

        String tempValue = aquarium.getTemperature();
        int tempResult = Integer.parseInt(tempValue);
        if(tempResult > 28 || tempResult < 23){
            temperature.setTextColor(Color.RED);
        }
    }
}
