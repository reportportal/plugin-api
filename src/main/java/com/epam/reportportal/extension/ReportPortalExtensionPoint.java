package com.epam.reportportal.extension;

import org.pf4j.ExtensionPoint;

import java.util.List;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface ReportPortalExtensionPoint extends ExtensionPoint {

	/**
	 * Return available plugin commands
	 *
	 * @return List of command names
	 */
	List<String> getCommandNames();

	/**
	 * Returns concrete plugin command
	 *
	 * @param commandName Command name
	 * @return {@link PluginCommand}
	 */
	PluginCommand getCommandToExecute(String commandName);

}
