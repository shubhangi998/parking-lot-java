package controller;

import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import dto.ResponseType;
import models.Ticket;
import service.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request){
        IssueTicketResponseDTO response= new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(request.getVehicleNumber(),request.getVehicleOwnerName(),request.getVehicleType(),request.getGateId());
            response.setTicket(ticket);
            response.setResponseType(ResponseType.SUCCESS);
        }catch (Exception e){
            response.setResponseType(ResponseType.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
       return response;
    }
}
