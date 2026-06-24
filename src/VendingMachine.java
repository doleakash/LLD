import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final Inventory inventory;
    private final CashInventory cashInventory;
    private int insertedAmount;

    private final Map<EDenomination, Integer> insertedCash;

    private InventoryItem selectedItem;

    private EMachineState machineState;
    private Transaction currentTransaction;


    public VendingMachine(Inventory inventory, CashInventory cashInventory) {
        this.inventory = inventory;
        this.cashInventory = cashInventory;
        this.insertedCash = new HashMap<>();
    }

    public void selectItem(InventoryItem item){
        if(!inventory.checkAvailability(item)){
            throw new RuntimeException("Invalid item or out of stock");
        }
        this.selectedItem = item;
    }

    public void insertMoney(EDenomination denomination, int count){
        if (count <= 0) {
            throw new RuntimeException("Invalid count");
        }
        this.insertedAmount += denomination.getValue() * count;
        insertedCash.put(denomination,insertedCash.getOrDefault(denomination,0)+count);
    }


    public int purchase(){
        if(selectedItem == null){
            throw new RuntimeException("No item selected");
        }
        if(!inventory.checkAvailability(selectedItem)){
            throw new RuntimeException("Item out of stock");
        }
        if(insertedAmount < selectedItem.getPrice()){
            throw new RuntimeException("Insufficient Amount Inserted");
        }

        inventory.decrementStock(selectedItem,1);

        for(Map.Entry<EDenomination,Integer> entry: insertedCash.entrySet()){
            cashInventory.addCash(entry.getKey(),entry.getValue());
        }

        int change = insertedAmount - selectedItem.getPrice();

        selectedItem = null;
        insertedAmount = 0;
        insertedCash.clear();

        return change;
    }

    public Map<EDenomination,Integer> refund(){
        Map<EDenomination,Integer> refundCash = new HashMap<>(insertedCash);

        selectedItem = null;
        insertedAmount = 0;
        insertedCash.clear();
        return refundCash;
    }


}
