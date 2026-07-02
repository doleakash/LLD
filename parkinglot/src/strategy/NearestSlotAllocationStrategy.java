package strategy;

import enums.EParkingFloorStatus;
import enums.EParkingSlotStatus;
import models.ParkingFloor;
import models.ParkingSlot;
import models.Vehicle;


import java.util.List;

public class NearestSlotAllocationStrategy implements ISlotAllocationStrategy {


    @Override
    public ParkingSlot allocateSlot(Vehicle vehicle, List<ParkingFloor> floors) {
        for (ParkingFloor floor : floors) {
            if (floor.isOpen()) {
                for (ParkingSlot parkingSlot : floor.getParkingSlots()) {
                    if (parkingSlot.isAvailable()
                            && parkingSlot.getParkingSlotType().getValue().equals(vehicle.getVehicleType().getValue())) {
                        return parkingSlot;
                    }
                }
            }
        }
        return null;
    }
}
