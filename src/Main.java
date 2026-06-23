import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = getVendingMachine();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            vendingMachine.displayItems();

            System.out.println(
                    "Enter Product Id (-1 to exit): "
            );

            int id = scanner.nextInt();

            if (id == -1) {
                break;
            }

            vendingMachine.selectItem(id);

            System.out.println(
                    "Insert Amount:"
            );

            int amount = scanner.nextInt();

            vendingMachine.insertMoney(amount);
        }


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
        inventory.addItem(chocolate,10);
        inventory.addItem(coke,2);

        return new VendingMachine(inventory);
    }
}