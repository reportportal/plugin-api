package com.epam.reportportal.extension;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface NamedPluginCommand<T> extends PluginCommand<T> {

	String getName();

}
