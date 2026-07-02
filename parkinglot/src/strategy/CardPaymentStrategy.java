package strategy;

import models.Payment;

import java.math.BigDecimal;

public class CardPaymentStrategy implements IPaymentStrategy{
    @Override
    public Payment charge(BigDecimal amount) {
        return null;
    }
}
