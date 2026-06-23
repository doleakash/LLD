public class Transaction {
    private final InventoryItem item;
    private int insertedAmount;
    private EPaymentMode paymentMode;
    private ETransactionStatus status;
    private int returnedAmount;

    public Transaction(InventoryItem item) {
        this.item = item;
        this.status =  ETransactionStatus.PENDING;
    }

    public EPaymentMode getPaymentMode() {
        return paymentMode;
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }

    public InventoryItem getItem() {
        return item;
    }

    public int getReturnedAmount() {
        return returnedAmount;
    }

    public ETransactionStatus getStatus() {
        return status;
    }

    public void update(int insertedAmount, EPaymentMode mode){
        this.insertedAmount = insertedAmount;
        this.paymentMode = mode;
        this.status = ETransactionStatus.SUCCESS;
        this.returnedAmount = insertedAmount - item.getPrice();
    }


}
