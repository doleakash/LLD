package models;

import enums.EPaymentMode;
import enums.EPaymentStatus;


import java.math.BigDecimal;

public class Payment {
    private String paymentId;
    private EPaymentMode paymentMode;
    private EPaymentStatus  paymentStatus;
    private BigDecimal amount;

    public Payment(String paymentId, EPaymentMode paymentMode, EPaymentStatus paymentStatus, BigDecimal amount) {
        this.paymentId = paymentId;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }
}
