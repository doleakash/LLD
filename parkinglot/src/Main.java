import enums.ESlotType;
import enums.EVehicleType;
import models.*;
import strategy.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingSlot bikeSlotOne = new ParkingSlot("B1", ESlotType.BIKE);
        ParkingSlot bikeSlotTwo = new ParkingSlot("B2", ESlotType.BIKE);
        ParkingSlot carSlotOne = new ParkingSlot("C1", ESlotType.CAR);
        ParkingSlot carSlotTwo = new ParkingSlot("C2", ESlotType.CAR);

        ParkingSlot bikeSlotThree = new ParkingSlot("B3", ESlotType.BIKE);
        ParkingSlot bikeSlotFour = new ParkingSlot("B4", ESlotType.BIKE);
        ParkingSlot carSlotThree = new ParkingSlot("C3", ESlotType.CAR);
        ParkingSlot carSlotFour = new ParkingSlot("C4", ESlotType.CAR);

        List<ParkingSlot> parkingSlotsOne = List.of(
                bikeSlotOne,
                bikeSlotTwo,
                carSlotOne,
                carSlotTwo
        );

        List<ParkingSlot> parkingSlotsTwo = List.of(
                carSlotThree,
                carSlotFour,
                bikeSlotThree,
                bikeSlotFour
        );

        ParkingFloor parkingFloorOne = new ParkingFloor("F1", parkingSlotsOne);
        ParkingFloor parkingFloorTwo = new ParkingFloor("F2", parkingSlotsTwo);

        List<ParkingFloor> parkingFloors = List.of(parkingFloorOne, parkingFloorTwo);

        EntryGate entryGateOne = new EntryGate("EG1");
        EntryGate entryGateTwo = new EntryGate("EG2");
        List<EntryGate> entryGates = List.of(entryGateOne, entryGateTwo);

        ExitGate exitGateOne = new ExitGate("EXG1");
        ExitGate exitGateTwo = new ExitGate("EXG2");
        List<ExitGate> exitGates = List.of(exitGateOne, exitGateTwo);


        IBillingStrategy billingStrategy = new GeneralBillingStrategy();
        ISlotAllocationStrategy slotAllocationStrategy = new NearestSlotAllocationStrategy();
        IPaymentStrategy paymentStrategy = new CardPaymentStrategy();


        ParkingLot parkingLot = new ParkingLot(parkingFloors, entryGates, exitGates, slotAllocationStrategy, billingStrategy, paymentStrategy);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Entry");
            System.out.println("2.Exit");
            System.out.println("3.Exit Program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String vehicleNumber = scanner.next();

                    System.out.print("Enter vehicle type (CAR/BIKE): ");
                    EVehicleType vehicleType = EVehicleType.valueOf(scanner.next().toUpperCase());

                    Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType);

                    Ticket ticket = entryGates.getFirst().parkVehicle(vehicle, parkingLot);
                    System.out.println(STR."ticket\{ticket.getVehicle().getVehicleNumber()}");
                    break;
                case 2:
                    System.out.print("Enter vehicle type: ");
                    break;
                case 3:
                    System.out.print("Exit Program");
                    return;
            }
        }

    }

}





