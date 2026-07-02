package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private final ParkingSlot parkingSlot;
    private BigDecimal parkingCharge;
    private Payment payment;
    private Vehicle vehicle;

    public Ticket(LocalDateTime entryTime, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = entryTime;
        this.exitTime = null;
        this.parkingSlot = parkingSlot;
        this.parkingCharge = null;
        this.payment = null;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void closeTicket(BigDecimal parkingCharge) {
        this.exitTime = LocalDateTime.now();
        this.parkingCharge = parkingCharge;
    }

    public void attachPayment(Payment payment) {
        this.payment = payment;
    }
}
