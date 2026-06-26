import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = getVendingMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nAvailable Products:");
            for (InventoryItem item : vendingMachine.displayItems()) {
                System.out.println(
                        item.getId() + ". "
                                + item.getName()
                                + " - ₹" + item.getPrice()
                );
            }

            System.out.println("\nEnter Product Id (-1 to exit):");
            int id = scanner.nextInt();

            if (id == -1) {
                break;
            }

            try {

                vendingMachine.selectItem(id);

                System.out.println("\nSupported Denominations:");
                for (EDenomination denomination : EDenomination.values()) {
                    System.out.print(denomination.getValue() + " ");
                }
                System.out.println();

                while (true) {

                    System.out.println("Insert denomination (0 to finish):");
                    int input = scanner.nextInt();

                    if (input == 0) {
                        break;
                    }

                    EDenomination selectedDenomination = null;

                    for (EDenomination denomination : EDenomination.values()) {
                        if (denomination.getValue() == input) {
                            selectedDenomination = denomination;
                            break;
                        }
                    }

                    if (selectedDenomination == null) {
                        System.out.println("Invalid denomination.");
                        continue;
                    }

                    vendingMachine.insertMoney(selectedDenomination);
                }

                PurchaseResult result = vendingMachine.purchase();

                System.out.println("\nProduct Dispensed: "
                        + result.getItem().getName());

                System.out.println("Change Returned:");

                for (Map.Entry<EDenomination, Integer> entry :
                        result.getChange().entrySet()) {

                    System.out.println(
                            entry.getKey().getValue()
                                    + " x "
                                    + entry.getValue()
                    );
                }

            } catch (RuntimeException e) {

                System.out.println(e.getMessage());

                try {
                    Map<EDenomination, Integer> refund =
                            vendingMachine.refund();

                    if (!refund.isEmpty()) {
                        System.out.println("Refund:");

                        for (Map.Entry<EDenomination, Integer> entry :
                                refund.entrySet()) {

                            System.out.println(
                                    entry.getKey().getValue()
                                            + " x "
                                            + entry.getValue()
                            );
                        }
                    }

                } catch (Exception ignored) {
                }
            }
        }

        scanner.close();
    }


    private static VendingMachine getVendingMachine() {
        InventoryItem chocolate =
                new InventoryItem(
                        1,
                        "Chocolate",
                        30
                );
        InventoryItem coke =
                new InventoryItem(
                        2,
                        "Coke",
                        20
                );

        Inventory inventory = new Inventory();
        inventory.addStock(chocolate, 10);
        inventory.addStock(coke, 2);

        CashInventory cashInventory = new CashInventory();
        cashInventory.addCash(EDenomination.TWENTY, 10);
        cashInventory.addCash(EDenomination.TEN, 10);
        cashInventory.addCash(EDenomination.FIVE, 5);
        cashInventory.addCash(EDenomination.TWO, 10);
        cashInventory.addCash(EDenomination.ONE, 10);

        return new VendingMachine(inventory, cashInventory);
    }
}