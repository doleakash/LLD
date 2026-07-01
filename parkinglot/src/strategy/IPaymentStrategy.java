package strategy;

import models.Payment;

import java.math.BigDecimal;

public interface IPaymentStrategy {
    public Payment charge(BigDecimal amount);
}
