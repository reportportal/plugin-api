package com.epam.reportportal.extension.auth;

import com.epam.reportportal.extension.auth.data.BeanData;

import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface BeanProvider {

	List<BeanData> getBeansToInitialize();

}
