import java.util.Map;

public class IdleState implements MachineState{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(int id) {
        Inventory inventory = vendingMachine.getInventory();

        InventoryItem inventoryItem = inventory.getItemById(id);
        if(inventoryItem == null){
            throw new RuntimeException("Invalid item selected");
        }
        if(!inventory.checkAvailability(inventoryItem)){
            throw new RuntimeException("Item not available");
        }

        vendingMachine.setCurrentTransaction(new Transaction(inventoryItem));

        vendingMachine.setMachineState(new ItemSelectedState(vendingMachine));
    }

    @Override
    public void insertMoney(EDenomination denomination) {
        throw new RuntimeException("Invalid Request idle money");
    }

    @Override
    public PurchaseResult purchase() {
        throw new RuntimeException("Invalid Request idle purchase");
    }

    @Override
    public Map<EDenomination, Integer> refund() {
        throw new RuntimeException("Invalid Request idle refund");
    }
}
