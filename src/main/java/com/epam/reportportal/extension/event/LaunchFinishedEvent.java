package com.epam.reportportal.extension.event;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public class LaunchFinishedEvent extends LaunchEvent<Long> {

	private final Long projectId;

	public LaunchFinishedEvent(Long source, Long projectId) {
		super(source);
		this.projectId = projectId;
	}

	public Long getProjectId() {
		return projectId;
	}
}
