import java.util.HashMap;
import java.util.Map;

public class Transaction {
    private final InventoryItem selectedItem;
    private ETransactionStatus status;
    private final Map<EDenomination, Integer> insertedCash;

    public Transaction(InventoryItem item) {
        this.selectedItem = item;
        this.status = ETransactionStatus.PENDING;
        this.insertedCash = new HashMap<>();
    }

    public void addMoney(EDenomination denomination) {
        insertedCash.put(denomination, insertedCash.getOrDefault(denomination, 0) + 1);
    }

    private int getTotalInsertedAmount() {
        int amount = 0;
        for (Map.Entry<EDenomination, Integer> entry : insertedCash.entrySet()) {
            amount += entry.getKey().getValue() * entry.getValue();
        }
        return amount;
    }

    public boolean isPaymentSufficient() {
        int price = selectedItem.getPrice();
        int amount = getTotalInsertedAmount();
        return amount >= price;
    }

    public InventoryItem getSelectedItem() {
        return selectedItem;
    }

    public Map<EDenomination, Integer> getInsertedCash() {
        return insertedCash;
    }

    public int getChangeAmount() {
        return getTotalInsertedAmount() - selectedItem.getPrice();
    }

    public void complete() {
        this.status = ETransactionStatus.SUCCESS;
    }

    public void cancel() {
        this.status = ETransactionStatus.CANCELLED;
    }

    public ETransactionStatus getStatus() {
        return status;
    }


}
