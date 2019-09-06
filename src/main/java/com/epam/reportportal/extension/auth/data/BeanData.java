package com.epam.reportportal.extension.auth.data;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public final class BeanData {

	private final String name;
	private final Object beanObject;

	public BeanData(String name, Object beanObject) {
		this.name = name;
		this.beanObject = beanObject;
	}

	public String getName() {
		return name;
	}

	public Object getBeanObject() {
		return beanObject;
	}
}
