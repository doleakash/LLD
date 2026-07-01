package strategy;

import models.ParkingFloor;
import models.ParkingSlot;
import models.Vehicle;

import java.util.List;

public interface ISlotAllocationStrategy {
    public ParkingSlot allocateSlot(Vehicle vehicle, List<ParkingFloor> floors);
}
