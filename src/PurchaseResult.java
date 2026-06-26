import java.util.Map;
public class PurchaseResult {

    private InventoryItem item;

    private Map<EDenomination, Integer> change;

    public void setChange(Map<EDenomination, Integer> change) {
        this.change = change;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    public Map<EDenomination, Integer> getChange() {
        return change;
    }

    public InventoryItem getItem() {
        return item;
    }
}