package models;

import enums.EVehicleType;

public class Vehicle {
    private String vehicleNumber;
    private EVehicleType vehicleType;

    public Vehicle(String vehicleNumber, EVehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public EVehicleType getVehicleType() {
        return vehicleType;
    }
}
