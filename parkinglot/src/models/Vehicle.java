package models;

public class Vehicle {
    private String vehicleNumber;
    private EVehicleType vehicleType;

    public Vehicle(String vehicleNumber, EVehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}
