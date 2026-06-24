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
        cashInventory.put(denomination,cashInventory.getOrDefault(denomination,0)+count);
    }

    public void removeCash(EDenomination denomination, Integer count){
        int available = cashInventory.getOrDefault(denomination,0);
        if(available < count){
            throw new RuntimeException("Insufficient cash");
        }

        cashInventory.put(denomination,available-count);
    }

    public int getCount(EDenomination denomination){
        return cashInventory.getOrDefault(denomination,0);
    }


}
