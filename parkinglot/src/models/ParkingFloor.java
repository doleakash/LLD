package models;

import enums.EParkingFloorStatus;

import java.util.List;

public class ParkingFloor {
    private String floorId;
    private EParkingFloorStatus parkingFloorStatus;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(String floorId, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.parkingFloorStatus = EParkingFloorStatus.OPEN;
        this.parkingSlots = parkingSlots;
    }

    public EParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public boolean isOpen() {
        return parkingFloorStatus == EParkingFloorStatus.OPEN;
    }
}
