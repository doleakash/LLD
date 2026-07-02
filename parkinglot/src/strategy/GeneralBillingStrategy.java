package strategy;

import models.Ticket;

import java.math.BigDecimal;

public class GeneralBillingStrategy implements IBillingStrategy {
    @Override
    public BigDecimal calculate(Ticket ticket) {
        return null;
    }
}
