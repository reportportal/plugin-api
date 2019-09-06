package com.epam.reportportal.extension.auth;

import com.epam.reportportal.extension.auth.data.BeanProviderData;

import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface InitializingExtensionPoint {

	List<BeanProviderData> getBeanProviders();
}
