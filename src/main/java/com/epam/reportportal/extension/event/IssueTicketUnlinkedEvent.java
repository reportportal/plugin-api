package com.epam.reportportal.extension.event;

import org.springframework.context.ApplicationEvent;

public class IssueTicketUnlinkedEvent extends ApplicationEvent {

    private final String ticketId;

    public IssueTicketUnlinkedEvent(Long issueId, String ticketId) {
        super(issueId);
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }
}
