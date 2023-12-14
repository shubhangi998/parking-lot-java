package service;

import models.Gate;
import models.ParkingSlot;
import models.Vehicle;
import models.VehicleTypes;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(Gate gate, VehicleTypes vehicleType);
}
