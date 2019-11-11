package com.epam.reportportal.extension;

import org.pf4j.ExtensionPoint;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface ReportPortalExtensionPoint extends ExtensionPoint {

	/**
	 * Return available plugin parameters
	 *
	 * @return Map of plugin params
	 */
	Map<String, ?> getPluginParams();

	/**
	 * Returns concrete plugin command
	 *
	 * @param commandName Command name
	 * @return {@link PluginCommand}
	 */
	PluginCommand getCommandToExecute(String commandName);

	default IntegrationGroupEnum getIntegrationGroup() {
		return IntegrationGroupEnum.OTHER;
	}

}
