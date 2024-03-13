package com.epam.reportportal.extension;

import com.epam.ta.reportportal.commons.ReportPortalUser;
import com.epam.ta.reportportal.commons.validation.BusinessRule;
import com.epam.ta.reportportal.commons.validation.Suppliers;
import com.epam.ta.reportportal.dao.ProjectRepository;
import com.epam.ta.reportportal.entity.project.Project;
import com.epam.ta.reportportal.exception.ReportPortalException;
import com.epam.ta.reportportal.ws.reporting.ErrorType;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public abstract class ProjectMemberCommand<T> extends AbstractRoleBasedCommand<T> {

	public static final String PROJECT_ID_PARAM = "projectId";


	protected final ProjectRepository projectRepository;

	protected ProjectMemberCommand(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public void validateRole(Map<String, Object> params) {
		Long projectId = retrieveLong(params, PROJECT_ID_PARAM);
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ReportPortalException(ErrorType.PROJECT_NOT_FOUND, projectId));

		ReportPortalUser user = (ReportPortalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BusinessRule.expect(user, Objects::nonNull).verify(ErrorType.ACCESS_DENIED);

		validatePermissions(user, project);
	}

	protected void validatePermissions(ReportPortalUser user, Project project) {
		BusinessRule.expect(ofNullable(user.getProjectDetails()).flatMap(detailsMapping -> ofNullable(detailsMapping.get(project.getName()))),
				Optional::isPresent
		).verify(ErrorType.ACCESS_DENIED);
	}

	public static Long retrieveLong(Map<String, Object> params, String param) {
		return ofNullable(params.get(param)).map(String::valueOf)
				.map(ProjectMemberCommand::safeParseLong)
				.orElseThrow(() -> new ReportPortalException(ErrorType.BAD_REQUEST_ERROR,
						Suppliers.formattedSupplier("Parameter '{}' was not provided", param).get()
				));
	}

	public static Long safeParseLong(String param) {
		try {
			return Long.parseLong(param);
		} catch (NumberFormatException ex) {
			throw new ReportPortalException(ErrorType.BAD_REQUEST_ERROR, ex.getMessage());
		}
	}
}
