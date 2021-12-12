package com.epam.reportportal.extension.event;

import java.util.Map;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class LaunchAnalysisFinishEvent extends LaunchEvent<Long> {

	private final Map<String, String> projectConfigParams;

	public LaunchAnalysisFinishEvent(Long source, Map<String, String> projectConfigParams) {
		super(source);
		this.projectConfigParams = projectConfigParams;
	}

	public Map<String, String> getProjectConfigParams() {
		return projectConfigParams;
	}
}
