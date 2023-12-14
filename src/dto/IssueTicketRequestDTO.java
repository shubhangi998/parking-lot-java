package dto;

import models.VehicleTypes;

public class IssueTicketRequestDTO {
    private String vehicleNumber;
    private String vehicleOwnerName;
    private Long GateId;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public Long getGateId() {
        return GateId;
    }

    public void setGateId(Long gateId) {
        GateId = gateId;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    private VehicleTypes vehicleType;

}
