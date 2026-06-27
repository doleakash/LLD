import java.util.Map;

public class ItemSelectedState implements MachineState{
    private final VendingMachine vendingMachine;

    public ItemSelectedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(int id) {
        throw new RuntimeException("Invalid Request Item selected");
    }

    @Override
    public void insertMoney(EDenomination denomination) {
        Transaction transaction = vendingMachine.getCurrentTransaction();
        transaction.addMoney(denomination);
        if (transaction.isPaymentSufficient()) {
            vendingMachine.setMachineState(
                    new ReadyToDispenseState(vendingMachine)
            );
        }
    }

    @Override
    public PurchaseResult purchase() {
        throw new RuntimeException("Insufficient Money");
    }

    @Override
    public Map<EDenomination, Integer> refund() {
        return vendingMachine.cancelTransaction();
    }
}
