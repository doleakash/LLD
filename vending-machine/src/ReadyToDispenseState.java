import java.util.Map;

public class ReadyToDispenseState implements MachineState {
    private final VendingMachine vendingMachine;

    public ReadyToDispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(int id) {
        throw new RuntimeException("Invalid Request item money inserted");
    }

    @Override
    public void insertMoney(EDenomination denomination) {
        Transaction transaction = vendingMachine.getCurrentTransaction();
        transaction.addMoney(denomination);
    }

    @Override
    public PurchaseResult purchase() {
        Transaction currentTransaction = vendingMachine.getCurrentTransaction();
        Inventory inventory = vendingMachine.getInventory();
        InventoryItem item = currentTransaction.getSelectedItem();
        CashInventory cashInventory = vendingMachine.getCashInventory();

        if (!currentTransaction.isPaymentSufficient()) {
            throw new RuntimeException("Insufficient Money Inserted");
        }

        if (!inventory.checkAvailability(item)) {
            throw new RuntimeException("Item out of Stock");
        }

        inventory.decrementStock(item, 1);

        Map<EDenomination, Integer> insertedMoney = currentTransaction.getInsertedCash();
        for (Map.Entry<EDenomination, Integer> entry : insertedMoney.entrySet()) {
            cashInventory.addCash(entry.getKey(), entry.getValue());
        }

        PurchaseResult purchaseResult = new PurchaseResult();
        purchaseResult.setItem(item);
        purchaseResult.setChange(cashInventory.dispenseChange(currentTransaction.getChangeAmount()));

        currentTransaction.complete();

        vendingMachine.resetTransaction();
        vendingMachine.setMachineState(new IdleState(vendingMachine));
        return purchaseResult;
    }

    @Override
    public Map<EDenomination, Integer> refund() {
        return vendingMachine.cancelTransaction();
    }
}
