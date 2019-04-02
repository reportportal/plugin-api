package com.epam.reportportal.extension;

import com.epam.ta.reportportal.entity.integration.Integration;
import org.apache.poi.ss.formula.functions.T;
import org.pf4j.ExtensionPoint;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:pavel_bortnik@epam.com">Pavel Bortnik</a>
 */
public interface ReportPortalExtensionPoint extends ExtensionPoint {

	List<String> getCommandNames();

	PluginCommand getCommandToExecute(String commandName);

}
