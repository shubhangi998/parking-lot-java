package dto;

import models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseType responseStatus;

    private String failureMessage;
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseType getResponseType() {
        return responseStatus;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseStatus = responseType;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

}
