package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ParkingSlot parkingSlot;
    private BigDecimal parkingCharge;
    private Payment payment;
    private Vehicle vehicle;

    public Ticket(String ticketId, LocalDateTime entryTime, LocalDateTime exitTime, ParkingSlot parkingSlot, BigDecimal parkingCharge, Payment payment, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingSlot = parkingSlot;
        this.parkingCharge = parkingCharge;
        this.payment = payment;
        this.vehicle = vehicle;
    }
}
