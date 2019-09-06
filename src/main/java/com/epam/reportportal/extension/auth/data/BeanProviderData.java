package com.epam.reportportal.extension.auth.data;

import com.epam.reportportal.extension.auth.BeanProvider;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public final class BeanProviderData {

	private String name;
	private Class<? extends BeanProvider> beanProviderClass;

	public BeanProviderData(String name, Class<? extends BeanProvider> beanProviderClass) {
		this.name = name;
		this.beanProviderClass = beanProviderClass;
	}

	public String getName() {
		return name;
	}

	public Class<? extends BeanProvider> getBeanProviderClass() {
		return beanProviderClass;
	}
}
