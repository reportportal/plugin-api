package com.epam.reportportal.extension.saucelabs;

import com.epam.reportportal.extension.bugtracking.BtsExtension;
import com.epam.ta.reportportal.entity.integration.Integration;
import org.json.JSONObject;
import org.pf4j.ExtensionPoint;

import java.io.InputStream;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface SaucelabsExtensionPoint extends ExtensionPoint {

	/**
	 * Downloads job video
	 *
	 * @param system     Integration parameters
	 * @param sessionId  Saucelabs job id
	 * @param dataCenter Saucelabs datacenter
	 * @return Video input stream
	 */
	InputStream downloadVideo(Integration system, String sessionId, String dataCenter);

	/**
	 * Detailed information about Saucelabs steps
	 *
	 * @param system     Integration parameters
	 * @param jobId      Saucelabs job id
	 * @param dataCenter Saucelabs datacenter
	 * @return Json object that contains steps
	 */
	Object getLogs(Integration system, String jobId, String dataCenter);

	/**
	 * Returns detailed information about the job
	 *
	 * @param system     Integration parameters
	 * @param jobId      Saucelabs job id
	 * @param dataCenter Saucelabs datacenter
	 * @return Json object that contains job information
	 */
	Object getJobInfo(Integration system, String jobId, String dataCenter);

}
