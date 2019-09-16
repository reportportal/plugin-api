package com.epam.reportportal.extension.event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class IntegrationEvent extends ApplicationEvent {

	private final List<Long> integrationIds;

	private final String integrationTypeName;

	private final IntegrationEventType eventType;

	public IntegrationEvent(List<Long> integrationIds, String integrationTypeName, IntegrationEventType eventType) {
		super(integrationIds);
		this.integrationIds = integrationIds;
		this.integrationTypeName = integrationTypeName;
		this.eventType = eventType;
	}

	public List<Long> getIntegrationIds() {
		return integrationIds;
	}

	public String getIntegrationTypeName() {
		return integrationTypeName;
	}

	public IntegrationEventType getEventType() {
		return eventType;
	}
}
