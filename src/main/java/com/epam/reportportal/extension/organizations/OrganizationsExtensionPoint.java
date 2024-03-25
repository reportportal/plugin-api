package com.epam.reportportal.extension.organizations;

import com.epam.ta.reportportal.commons.ReportPortalUser;
import com.epam.ta.reportportal.ws.model.EntryCreatedRS;
import org.pf4j.ExtensionPoint;

public interface OrganizationsExtensionPoint extends ExtensionPoint {

  EntryCreatedRS createOrganization(String orgName, ReportPortalUser user);

  EntryCreatedRS updateOrganization(String id, String orgName, ReportPortalUser user);

  EntryCreatedRS deleteOrganization(String id, ReportPortalUser user);

}
