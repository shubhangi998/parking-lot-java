import controller.TicketController;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import service.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
       GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService = new TicketService(gateRepository,vehicleRepository,parkingLotRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

    }
}