package com.epam.reportportal.extension.auth;

import java.util.Map;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface InitializingExtensionPoint {

	Map<String, Class<?>> getBeansToInitialize();
}
