package models;

import enums.EParkingLotStatus;
import strategy.IBillingStrategy;
import strategy.IPaymentStrategy;
import strategy.ISlotAllocationStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloors;
    private final List<EntryGate> entryGates;
    private final List<ExitGate> exitGates;
    private EParkingLotStatus status;
    private final ISlotAllocationStrategy slotAllocationStrategy;
    private final IBillingStrategy billingCalculationStrategy;
    private final IPaymentStrategy paymentStrategy;

    public ParkingLot(List<ParkingFloor> parkingFloors, List<EntryGate> entryGates, List<ExitGate> exitGates, ISlotAllocationStrategy slotAllocationStrategy, IBillingStrategy billingCalculationStrategy, IPaymentStrategy paymentStrategy) {
        this.parkingFloors = parkingFloors;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.status = EParkingLotStatus.OPEN;
        this.slotAllocationStrategy = slotAllocationStrategy;
        this.billingCalculationStrategy = billingCalculationStrategy;
        this.paymentStrategy = paymentStrategy;
    }

    public Ticket allocateSlot(Vehicle vehicle) {
        ParkingSlot slot = slotAllocationStrategy.allocateSlot(vehicle,parkingFloors);
        if(slot == null){
            throw new RuntimeException("Slot not available");
        };
        slot.park(vehicle);
        return new Ticket(LocalDateTime.now(), slot, vehicle);
    }
}
