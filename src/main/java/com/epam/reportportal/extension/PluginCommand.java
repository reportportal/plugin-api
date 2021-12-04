package com.epam.reportportal.extension;

import com.epam.ta.reportportal.entity.integration.Integration;

import java.util.Map;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface PluginCommand<T> extends NamedPluginCommand {

	/**
	 * Executes plugin command for existed integration
	 *
	 * @param integration Configured ReportPortal integration
	 * @param params      Plugin Command parameters
	 * @return Result
	 */
	T executeCommand(Integration integration, Map<String, Object> params);

}
