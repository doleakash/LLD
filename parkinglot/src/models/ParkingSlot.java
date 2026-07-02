package models;

import enums.EParkingSlotStatus;
import enums.ESlotType;

public class ParkingSlot {
    private final String slotId;
    private EParkingSlotStatus parkingSlotStatus;
    private final ESlotType parkingSlotType;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, ESlotType parkingSlotType) {
        this.slotId = slotId;
        this.parkingSlotStatus = EParkingSlotStatus.AVAILABLE;
        this.parkingSlotType = parkingSlotType;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ESlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public EParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public String getSlotId() {
        return slotId;
    }

    public void park(Vehicle vehicle) {
        if(!isAvailable()) {
            throw new RuntimeException("Slot already occupied");
        }
        this.vehicle = vehicle;
        this.parkingSlotStatus = EParkingSlotStatus.OCCUPIED;
    }

    public boolean isAvailable() {
        return parkingSlotStatus == EParkingSlotStatus.AVAILABLE;
    }

    public void release() {
        if (isAvailable()) {
            throw new RuntimeException("Slot is already available");
        }
        this.vehicle = null;
        this.parkingSlotStatus = EParkingSlotStatus.AVAILABLE;

    }
}
