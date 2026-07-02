package models;

import enums.EGateStatus;

public class EntryGate extends Gate {

    public EntryGate(String gateId) {
        super(gateId,EGateStatus.OPEN);
    }

    public Ticket parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        return parkingLot.allocateSlot(vehicle);
    }
}
