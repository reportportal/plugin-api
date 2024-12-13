package com.epam.reportportal.extension.organizations;

import com.epam.ta.reportportal.commons.ReportPortalUser;
import org.pf4j.ExtensionPoint;

public interface OrganizationsExtensionPoint extends ExtensionPoint {

  Object createOrganization(String orgName, ReportPortalUser user);


  void updateOrganization(String orgName, ReportPortalUser user);

}
