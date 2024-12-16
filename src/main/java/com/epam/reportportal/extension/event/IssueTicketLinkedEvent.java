package com.epam.reportportal.extension.event;

import org.springframework.context.ApplicationEvent;

public class IssueTicketLinkedEvent extends ApplicationEvent {

    private final String ticketId;

    public IssueTicketLinkedEvent(long issueId, String ticketId) {
        super(issueId);
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }
}
