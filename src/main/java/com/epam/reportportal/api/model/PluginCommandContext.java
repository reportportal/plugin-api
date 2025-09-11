package com.epam.reportportal.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.Objects;
import org.springframework.lang.Nullable;

/**
 * Context parameters defining where the command should be executed.  Scope can be omitted and is derived from provided identifiers:  - If &#x60;project_id&#x60; is present → scope is &#x60;PROJECT&#x60;. - Else if &#x60;org_id&#x60; is present → scope is &#x60;ORGANIZATION&#x60;. - Else → scope is &#x60;GLOBAL&#x60;.  When &#x60;scope&#x60; is explicitly provided, it is authoritative: the request MUST include only the identifiers required for that scope and MUST NOT include extra identifiers (e.g., &#x60;project_id&#x60; is not allowed for &#x60;ORGANIZATION&#x60;). For &#x60;PROJECT&#x60;, &#x60;org_id&#x60; is optional but, if provided, should match the organization of the project.
 */
@Schema(name = "PluginCommandContext", description = "Context parameters defining where the command should be executed.  Scope can be omitted and is derived from provided identifiers:  - If `project_id` is present → scope is `PROJECT`. - Else if `org_id` is present → scope is `ORGANIZATION`. - Else → scope is `GLOBAL`.  When `scope` is explicitly provided, it is authoritative: the request MUST include only the identifiers required for that scope and MUST NOT include extra identifiers (e.g., `project_id` is not allowed for `ORGANIZATION`). For `PROJECT`, `org_id` is optional but, if provided, should match the organization of the project.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")public class PluginCommandContext {

  private @Nullable ContextScope scope;

  private @Nullable Long orgId;

  private @Nullable Long projectId;

  public PluginCommandContext() {
    super();
  }

  /**
   * Constructor with all args parameters
   */
  public PluginCommandContext(@Nullable ContextScope scope, @Nullable Long orgId, @Nullable Long projectId) {
      this.scope = scope;
      this.orgId = orgId;
      this.projectId = projectId;
  }

  public PluginCommandContext scope(ContextScope scope) {
    this.scope = scope;
    return this;
  }

  /**
   * Get scope
   * @return scope
   */
  @Valid   @Schema(name = "scope", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("scope")
  public ContextScope getScope() {
    return scope;
  }

  public void setScope(ContextScope scope) {
    this.scope = scope;
  }

  public PluginCommandContext orgId(Long orgId) {
    this.orgId = orgId;
    return this;
  }

  /**
   * Resource identifier.
   * minimum: 1
   * @return orgId
   */
  @Min(1L)   @Schema(name = "org_id", description = "Resource identifier.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
   * Resource identifier.
   * minimum: 1
   * @return projectId
   */
  @Min(1L)   @Schema(name = "project_id", description = "Resource identifier.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    return Objects.equals(this.scope, pluginCommandContext.scope) &&
        Objects.equals(this.orgId, pluginCommandContext.orgId) &&
        Objects.equals(this.projectId, pluginCommandContext.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scope, orgId, projectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PluginCommandContext {\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
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
        this.instance.setScope(value.scope);
        this.instance.setOrgId(value.orgId);
        this.instance.setProjectId(value.projectId);
        return this;
      }
  
        public Builder scope(ContextScope scope) {
        this.instance.scope(scope);
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
      *
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

