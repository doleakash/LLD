package models;

import enums.EGateStatus;

public class ExitGate extends Gate{
    public ExitGate(String gateId) {
        super(gateId, EGateStatus.OPEN);
    }
}
