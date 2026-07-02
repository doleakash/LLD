package models;

import enums.EGateStatus;

public abstract class Gate{
    private String GateId;
    private EGateStatus gateStatus;

    public Gate(String gateId, EGateStatus gateStatus) {
        GateId = gateId;
        this.gateStatus = gateStatus;
    }

    public EGateStatus getGateStatus() {
        return gateStatus;
    }
}
