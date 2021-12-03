package com.epam.reportportal.extension.event;

import java.util.Map;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class LaunchUniqueErrorAnalysisFinishEvent extends LaunchEvent<Long> {

	private final Map<String, Object> metadata;

	public LaunchUniqueErrorAnalysisFinishEvent(Long source, Map<String, Object> metadata) {
		super(source);
		this.metadata = metadata;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}
}
