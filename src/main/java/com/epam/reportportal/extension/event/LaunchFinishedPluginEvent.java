package com.epam.reportportal.extension.event;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public class LaunchFinishedPluginEvent extends LaunchEvent<Long> {

	private final Long projectId;

	public LaunchFinishedPluginEvent(Long source, Long projectId) {
		super(source);
		this.projectId = projectId;
	}

	public Long getProjectId() {
		return projectId;
	}
}
