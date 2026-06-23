import java.util.Map;

public class CashInventory {
    private Map<EDenomination, Integer> denomination;

    public CashInventory(Map<EDenomination, Integer> denomination) {
        this.denomination = denomination;
    }
}
