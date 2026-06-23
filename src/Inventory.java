import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<InventoryItem,Integer> inventoryItems;

    public Inventory() {
        inventoryItems = new HashMap<>();
    }

    public void addItem(InventoryItem item, int quantity){
        inventoryItems.put(item, quantity);
    }


    public Map<InventoryItem, Integer> displayItems(){
        return inventoryItems;
    }


    public InventoryItem findItem(int id){
        for(InventoryItem item: inventoryItems.keySet()){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }


    public boolean checkAvailability(InventoryItem item){
        return inventoryItems.getOrDefault(item, 0) > 0;
    }


    public void decrementStock(InventoryItem item){
        Integer quantity = inventoryItems.get(item);

        if(quantity == null || quantity <= 0){
            throw new RuntimeException("Item out of stock");
        }
        System.out.println("item name: " + item.getName() + " quantity: " + inventoryItems.get(item));
        inventoryItems.put(item,quantity-1);
    }
}
