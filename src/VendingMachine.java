import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Inventory inventory;
    private final CashInventory cashInventory;
    private EMachineState machineState;
    private Transaction currentTransaction;


    public VendingMachine(Inventory inventory, CashInventory cashInventory) {
        this.inventory = inventory;
        this.cashInventory = cashInventory;
    }

    public List<InventoryItem> displayItems() {
        return inventory.getAvailableProducts();
    }

    public void selectItem(int id) {
        InventoryItem item = inventory.getItemById(id);
        if (item == null) {
            throw new RuntimeException("Invalid item");
        }
        if (!inventory.checkAvailability(item)) {
            throw new RuntimeException("Invalid item or out of stock");
        }
        currentTransaction = new Transaction(item);
    }

    private void resetTransaction() {
        if(currentTransaction == null){
            throw new RuntimeException("Select an item first");
        }
        currentTransaction = null;
    }

    public void insertMoney(EDenomination denomination) {
        currentTransaction.addMoney(denomination);
    }


    public PurchaseResult purchase() {
        if (!currentTransaction.isPaymentSufficient()) {
            throw new RuntimeException("Insufficient Inserted Amount");
        }

        if (!inventory.checkAvailability(currentTransaction.getSelectedItem())) {
            throw new RuntimeException("Item out of stock");
        }

        inventory.decrementStock(currentTransaction.getSelectedItem(), 1);

        Map<EDenomination, Integer> insertedCash = currentTransaction.getInsertedCash();
        for (Map.Entry<EDenomination, Integer> entry : insertedCash.entrySet()) {
            cashInventory.addCash(entry.getKey(), entry.getValue());
        }

        PurchaseResult purchaseResult = new PurchaseResult();
        purchaseResult.setChange(cashInventory.dispenseChange(currentTransaction.getChangeAmount()));
        purchaseResult.setItem(currentTransaction.getSelectedItem());

        currentTransaction.complete();
        resetTransaction();

        return purchaseResult;
    }

    public Map<EDenomination, Integer> refund() {
        currentTransaction.cancel();

        Map<EDenomination, Integer> refundCash = currentTransaction.getInsertedCash();

        resetTransaction();

        return refundCash;
    }


}
