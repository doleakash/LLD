package models;

import enums.EPaymentMode;
import enums.EPaymentStatus;


import java.math.BigDecimal;
import java.util.UUID;

public class Payment {
    private final String paymentId;
    private final EPaymentMode paymentMode;
    private EPaymentStatus  paymentStatus;
    private final BigDecimal amount;

    public Payment(EPaymentMode paymentMode, BigDecimal amount) {
        this.paymentId = UUID.randomUUID().toString();
        this.paymentMode = paymentMode;
        this.paymentStatus = EPaymentStatus.PENDING;
        this.amount = amount;
    }

    public void markFail() {
        this.paymentStatus = EPaymentStatus.FAILED;
    }
    public void markSuccess() {
        this.paymentStatus = EPaymentStatus.SUCCESS;
    }
}
