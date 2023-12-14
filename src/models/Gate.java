package models;

public class Gate extends BaseModel{
    private  int gateNumber;
    private Operator currentOperator;
    private GateStatus gateStatus;
    private GateTypes gateType;

    public int getGateNumber() {
        return gateNumber;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateTypes getGateType() {
        return gateType;
    }

    public void setGateType(GateTypes gateType) {
        this.gateType = gateType;
    }
}
