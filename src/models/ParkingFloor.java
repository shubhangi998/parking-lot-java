package models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSlot> parkingSlots;
    private List<VehicleTypes> allowedVehicleTypes;
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;
}
