package models;

import enums.EParkingSlotStatus;
import enums.ESlotType;

public class ParkingSlot {
    private String SlotId;
    private EParkingSlotStatus parkingSlotStatus;
    private ESlotType parkingSlotType;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, EParkingSlotStatus parkingSlotStatus, ESlotType parkingSlotType, Vehicle vehicle) {
        SlotId = slotId;
        this.parkingSlotStatus = parkingSlotStatus;
        this.parkingSlotType = parkingSlotType;
        this.vehicle = vehicle;
    }
}
