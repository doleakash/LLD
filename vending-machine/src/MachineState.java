import java.util.Map;

public interface MachineState {
    public void selectItem(int id);
    public void insertMoney(EDenomination denomination);
    public PurchaseResult purchase();
    Map<EDenomination, Integer> refund();
}
