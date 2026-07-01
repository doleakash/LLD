package models;

import enums.EParkingFloorStatus;

import java.util.List;

public class ParkingFloor {
    private String floorId;
    private EParkingFloorStatus parkingFloorStatus;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(String floorId, EParkingFloorStatus parkingFloorStatus, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.parkingFloorStatus = parkingFloorStatus;
        this.parkingSlots = parkingSlots;
    }
}
