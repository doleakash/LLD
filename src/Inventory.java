import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<InventoryItem, Integer> inventoryItems;

    public Inventory() {
        inventoryItems = new HashMap<>();
    }


    public void addStock(InventoryItem item, int quantity) {
        inventoryItems.put(item, inventoryItems.getOrDefault(item, 0) + quantity);
    }

    public int getStock(InventoryItem item) {
        return inventoryItems.getOrDefault(item, 0);
    }

    public boolean checkAvailability(InventoryItem item) {
        return inventoryItems.getOrDefault(item, 0) > 0;
    }


    public void decrementStock(InventoryItem item, int quantity) {
        Integer stock = inventoryItems.getOrDefault(item, 0);
        if (stock < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        inventoryItems.put(item, stock - quantity);
    }


    public List<InventoryItem> getAvailableProducts() {
        List<InventoryItem> items = new ArrayList<>();
        for (Map.Entry<InventoryItem, Integer> entry : inventoryItems.entrySet()) {
            if (entry.getValue() > 0) {
                items.add(entry.getKey());
            }
        }
        return items;
    }

    public InventoryItem getItemById(int id) {
        for (InventoryItem item : inventoryItems.keySet()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


}
