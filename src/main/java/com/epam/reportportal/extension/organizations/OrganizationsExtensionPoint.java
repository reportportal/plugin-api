package com.epam.reportportal.extension.organizations;

import com.epam.ta.reportportal.commons.ReportPortalUser;
import com.epam.ta.reportportal.ws.model.EntryCreatedRS;

public interface OrganizationsExtensionPoint {

  EntryCreatedRS createOrganization(String orgName, ReportPortalUser user);

  EntryCreatedRS updateOrganization(String id, String orgName, ReportPortalUser user);

  EntryCreatedRS deleteOrganization(String id, ReportPortalUser user);

}
