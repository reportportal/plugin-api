package com.epam.reportportal.extension.bugtracking;

import com.epam.ta.reportportal.entity.integration.Integration;
import com.epam.ta.reportportal.ws.model.externalsystem.PostFormField;
import com.epam.ta.reportportal.ws.model.externalsystem.PostTicketRQ;
import com.epam.ta.reportportal.ws.model.externalsystem.Ticket;
import org.pf4j.ExtensionPoint;

import java.util.List;
import java.util.Optional;

public interface BtsExtension extends ExtensionPoint {

	/**
	 * Test connection to external system with provided details
	 *
	 * @param system - external system details
	 * @return TRUE if connection is successful. Otherwise FALSE or throws an exception if no such external system is present
	 */
	boolean connectionTest(Integration system);

	/**
	 * Get ticket by ID
	 *
	 * @param id     ID of ticket
	 * @param system ExternalSystem
	 * @return Found Ticket
	 */
	Optional<Ticket> getTicket(String id, Integration system);

	/**
	 * Submit ticket into external system
	 *
	 * @param ticketRQ Create ticket DTO
	 * @param system   External system
	 * @return Created Ticket
	 */
	Ticket submitTicket(PostTicketRQ ticketRQ, Integration system);

	/**
	 * Get map of fields for ticket POST into external system
	 *
	 * @param issueType Type of issue
	 * @param system    External system
	 * @return List of form fields
	 */
	List<PostFormField> getTicketFields(String issueType, Integration system);

	/**
	 * Get list of allowable issue types for external system
	 *
	 * @param system External system
	 * @return List of issue types
	 */
	List<String> getIssueTypes(Integration system);
}
