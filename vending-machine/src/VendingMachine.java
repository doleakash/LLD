import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Inventory inventory;
    private final CashInventory cashInventory;
    private Transaction currentTransaction;
    private MachineState machineState;


    public VendingMachine(Inventory inventory, CashInventory cashInventory) {
        this.inventory = inventory;
        this.cashInventory = cashInventory;
        this.machineState = new IdleState(this);
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    public CashInventory getCashInventory() {
        return cashInventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public List<InventoryItem> displayItems() {
        return inventory.getAvailableProducts();
    }

    public void selectItem(int id) {
        machineState.selectItem(id);
    }

    public void resetTransaction() {
        currentTransaction = null;
    }

    public void insertMoney(EDenomination denomination) {
        machineState.insertMoney(denomination);
    }


    public PurchaseResult purchase() {
        return machineState.purchase();
    }

    public Map<EDenomination, Integer> refund() {
        return machineState.refund();
    }

    public Map<EDenomination, Integer> cancelTransaction() {

        currentTransaction.cancel();

        Map<EDenomination, Integer> refund = currentTransaction.getInsertedCash();

        resetTransaction();

        setMachineState(new IdleState(this));

        return refund;
    }
}
