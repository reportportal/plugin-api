package com.epam.reportportal.extension;

import org.pf4j.ExtensionPoint;

import java.util.Map;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface ReportPortalExtensionPoint extends ExtensionPoint {

	/**
	 * Should be provided in the {@link #getPluginParams()} method
	 * as a key parameter key. Value is supported commands by plugin
	 */
	String ALLOWED_COMMANDS = "allowedCommands";

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
	PluginCommand getCommonCommand(String commandName);

	/**
	 * Returns concrete plugin command for existed integration
	 *
	 * @param commandName Command name
	 * @return {@link IntegrationCommand}
	 */
	IntegrationCommand getIntegrationCommand(String commandName);

	default IntegrationGroupEnum getIntegrationGroup() {
		return IntegrationGroupEnum.OTHER;
	}

}
