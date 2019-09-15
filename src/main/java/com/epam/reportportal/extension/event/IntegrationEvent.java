package com.epam.reportportal.extension.event;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class IntegrationEvent {

	private Long integrationId;

	private String integrationTypeName;

	private IntegrationEventType eventType;

	public IntegrationEvent(Long integrationId, String integrationTypeName, IntegrationEventType eventType) {
		this.integrationId = integrationId;
		this.integrationTypeName = integrationTypeName;
		this.eventType = eventType;
	}

	public Long getIntegrationId() {
		return integrationId;
	}

	public String getIntegrationTypeName() {
		return integrationTypeName;
	}

	public IntegrationEventType getEventType() {
		return eventType;
	}
}
