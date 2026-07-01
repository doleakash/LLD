package models;

import enums.EParkingLotStatus;
import strategy.IBillingStrategy;
import strategy.ISlotAllocationStrategy;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingfloors;
    private List<EntryGate> entryGate;
    private List<ExitGate> exitGate;
    private EParkingLotStatus status;
    private ISlotAllocationStrategy slotAllocationStratergy;
    private IBillingStrategy billingCalculationStratergy;

    public ParkingLot(List<ParkingFloor> parkingfloors, List<EntryGate> entryGate, List<ExitGate> exitGate, EParkingLotStatus status, ISlotAllocationStrategy slotAllocationStratergy, IBillingStrategy billingCalculationStratergy) {
        this.parkingfloors = parkingfloors;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.status = status;
        this.slotAllocationStratergy = slotAllocationStratergy;
        this.billingCalculationStratergy = billingCalculationStratergy;
    }

}