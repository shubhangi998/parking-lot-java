package service;

import exceptions.GateNotFoundException;
import factory.SlotAssignmentStrategyFactory;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(String vehicleNumber, String vehicleOwnerName, VehicleTypes vehicleType, Long gateId) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        // set gate
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        // set vehicle
        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }else{
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);

        //Assign a slot
        SlotAssignmentStrategyType slotAssignmentStrategyType = parkingLotRepository
                .getParkingLot(gate)
                .getSlotAssignmentStrategyType();
        ParkingSlot parkingSlot = SlotAssignmentStrategyFactory
                .getSlotAssignmentStrategy(slotAssignmentStrategyType)
                .getSlot(gate,vehicleType);
        ticket.setParkingSlot(parkingSlot);
        ticket = ticketRepository.saveTicket(ticket);
        ticket.setTicketNumber("TICKET - "+ ticket.getId());
        return null;
    }
}
