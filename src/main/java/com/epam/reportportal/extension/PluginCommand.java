package com.epam.reportportal.extension;

import com.epam.ta.reportportal.entity.integration.Integration;
import com.epam.ta.reportportal.entity.integration.IntegrationParams;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface PluginCommand<T> {

	T executeCommand(Integration integration, Map<String, Object> params);

}
