package com.epam.reportportal.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Min;
import java.util.Objects;
import org.springframework.lang.Nullable;

/**
 * Context parameters defining where the command should be executed.  Scope is derived from provided identifiers:  - If
 * &#x60;project_id&#x60; is present → scope is &#x60;PROJECT&#x60;. - Else if &#x60;org_id&#x60; is present → scope is
 * &#x60;ORGANIZATION&#x60;. - Else → scope is &#x60;GLOBAL&#x60;.  The request MUST include only the identifiers
 * required for the derived scope  and MUST NOT include extra identifiers.
 */
@Schema(name = "PluginCommandContext", description = "Context parameters defining where the command should be executed.  Scope is derived from provided identifiers:  - If `project_id` is present → scope is `PROJECT`. - Else if `org_id` is present → scope is `ORGANIZATION`. - Else → scope is `GLOBAL`.  The request MUST include only the identifiers required for the derived scope  and MUST NOT include extra identifiers.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")
public class PluginCommandContext {

  private @Nullable Long orgId;

  private @Nullable Long projectId;

  public PluginCommandContext() {
    super();
  }

  /**
   * Constructor with all args parameters
   */
  public PluginCommandContext(@Nullable Long orgId, @Nullable Long projectId) {
    this.orgId = orgId;
    this.projectId = projectId;
  }

  public PluginCommandContext orgId(Long orgId) {
    this.orgId = orgId;
    return this;
  }

  /**
   * Organization identifier; required for ORGANIZATION; optional for PROJECT (if applicable). minimum: 1
   *
   * @return orgId
   */
  @Min(1L)
  @Schema(name = "org_id", description = "Organization identifier; required for ORGANIZATION; optional for PROJECT (if applicable).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("org_id")
  public Long getOrgId() {
    return orgId;
  }

  public void setOrgId(Long orgId) {
    this.orgId = orgId;
  }

  public PluginCommandContext projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * Project identifier; required for PROJECT scope. minimum: 1
   *
   * @return projectId
   */
  @Min(1L)
  @Schema(name = "project_id", description = "Project identifier; required for PROJECT scope.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("project_id")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PluginCommandContext pluginCommandContext = (PluginCommandContext) o;
    return Objects.equals(this.orgId, pluginCommandContext.orgId) &&
        Objects.equals(this.projectId, pluginCommandContext.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orgId, projectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PluginCommandContext {\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public static class Builder {

    private PluginCommandContext instance;

    public Builder() {
      this(new PluginCommandContext());
    }

    protected Builder(PluginCommandContext instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PluginCommandContext value) {
      this.instance.setOrgId(value.orgId);
      this.instance.setProjectId(value.projectId);
      return this;
    }

    public Builder orgId(Long orgId) {
      this.instance.orgId(orgId);
      return this;
    }

    public Builder projectId(Long projectId) {
      this.instance.projectId(projectId);
      return this;
    }

    /**
     * returns a built PluginCommandContext instance.
     * <p>
     * The builder is not reusable (NullPointerException)
     */
    public PluginCommandContext build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
   * Create a builder with no initialized field (except for the default values).
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Create a builder with a shallow copy of this instance.
   */
  public Builder toBuilder() {
    Builder builder = new Builder();
    return builder.copyOf(this);
  }
}

