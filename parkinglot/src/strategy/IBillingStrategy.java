package strategy;

import models.Ticket;

import java.math.BigDecimal;

public interface IBillingStrategy {
    public BigDecimal calculate(Ticket ticket);
}
