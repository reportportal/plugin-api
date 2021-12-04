package com.epam.reportportal.extension;

import java.util.Map;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface CommonPluginCommand<T> {

	/**
	 * Executes plugin command without existed integration
	 *
	 * @param params Plugin Command parameters
	 * @return Result
	 */
	T executeCommand(Map<String, Object> params);
}
