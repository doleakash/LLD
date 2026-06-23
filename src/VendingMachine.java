import java.util.Map;

public class VendingMachine {
    private EMachineState machineState;
    private Transaction currentTransaction;
    private CashInventory cashInventory;
    private Inventory inventory;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
    }


    public void displayItems(){
        Map<InventoryItem, Integer> display = inventory.displayItems();

        for(InventoryItem item: display.keySet()){
            System.out.println(item);
        }
    }


    public void selectItem(int id){
        InventoryItem item = inventory.findItem(id);

        if(inventory.checkAvailability(item)){
            throw new RuntimeException("Item out of stock");
        };

        System.out.println("selected: " + item.getName() + ", Please insert money.");

        currentTransaction = new Transaction(item);
    }


    public void insertMoney(int insertedMoney){
        Transaction transaction = currentTransaction;
        if(insertedMoney < transaction.getItem().getPrice()){
            throw new RuntimeException("Invalid Amount");
        }

        InventoryItem item = inventory.findItem(transaction.getItem().getId());
        if(item == null){
            throw new RuntimeException("Invalid Item");
        }
        if(!inventory.checkAvailability(item)){
            throw new RuntimeException("Item out of stock");
        };
        inventory.decrementStock(item);


        transaction.update(insertedMoney, EPaymentMode.CASH);

        System.out.println(item.getName() + " dispensed");

        if(transaction.getReturnedAmount() > 0){
            System.out.println("Return amount : " + transaction.getReturnedAmount());
        }
    }


}
