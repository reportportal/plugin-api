/*
 * Copyright 2019 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
