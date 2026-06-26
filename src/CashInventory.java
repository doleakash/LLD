import java.util.HashMap;
import java.util.Map;

public class CashInventory {
    private final Map<EDenomination, Integer> cashInventory;

    public CashInventory() {
        cashInventory = new HashMap<>();
    }

    public Map<EDenomination, Integer> getDenomination() {
        return cashInventory;
    }

    public void addCash(EDenomination denomination, Integer count) {
        cashInventory.put(denomination, cashInventory.getOrDefault(denomination, 0) + count);
    }

    public void removeCash(EDenomination denomination, Integer count) {
        int available = cashInventory.getOrDefault(denomination, 0);
        if (available < count) {
            throw new RuntimeException("Insufficient cash");
        }
        cashInventory.put(denomination, available - count);
    }

    public int getCount(EDenomination denomination) {
        return cashInventory.getOrDefault(denomination, 0);
    }

    public Map<EDenomination, Integer> dispenseChange(int amount) {
        Map<EDenomination, Integer> change = new HashMap<>();

        for (EDenomination denomination : EDenomination.values()) {
            int value = denomination.getValue();

            int available = cashInventory.getOrDefault(denomination, 0);

            int required = amount / value;

            int toDispense = Math.min(required, available);

            if (toDispense > 0) {
                change.put(denomination, toDispense);
            }

            amount -= toDispense * value;
        }

        if (amount != 0) {
            throw new RuntimeException("Unable to dispense exact amount");
        }

        for (Map.Entry<EDenomination, Integer> entry : change.entrySet()) {
            removeCash(entry.getKey(), entry.getValue());
        }

        return change;
    }

}
