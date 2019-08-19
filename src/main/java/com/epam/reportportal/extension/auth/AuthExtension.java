package com.epam.reportportal.extension.auth;

import com.epam.reportportal.extension.IntegrationGroupEnum;
import com.epam.reportportal.extension.ReportPortalExtensionPoint;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface AuthExtension extends InitializingExtensionPoint, ReportPortalExtensionPoint {
	@Override
	default IntegrationGroupEnum getIntegrationGroup() {
		return IntegrationGroupEnum.AUTH;
	}
}
