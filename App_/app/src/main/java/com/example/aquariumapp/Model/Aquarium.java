package com.example.aquariumapp.Model;

public class Aquarium {
    private String Temperature;
    private String waterLevel;

    public Aquarium(String temperature, String waterLevel) {
        this.Temperature = temperature;
        this.waterLevel = waterLevel;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        this.Temperature = temperature;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }
}
