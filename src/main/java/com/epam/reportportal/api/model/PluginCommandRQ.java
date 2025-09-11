package com.epam.reportportal.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import java.util.Objects;
import org.springframework.lang.Nullable;

/**
 * Request payload to execute a plugin command in a given context.
 */
@Schema(name = "PluginCommandRQ", description = "Request payload to execute a plugin command in a given context.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.11.0")public class PluginCommandRQ {

  private @Nullable PluginCommandContext context;

  private @Nullable Object arguments;

  public PluginCommandRQ() {
    super();
  }

  /**
   * Constructor with all args parameters
   */
  public PluginCommandRQ(@Nullable PluginCommandContext context, @Nullable Object arguments) {
      this.context = context;
      this.arguments = arguments;
  }

  public PluginCommandRQ context(PluginCommandContext context) {
    this.context = context;
    return this;
  }

  /**
   * Get context
   * @return context
   */
  @Valid   @Schema(name = "context", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("context")
  public PluginCommandContext getContext() {
    return context;
  }

  public void setContext(PluginCommandContext context) {
    this.context = context;
  }

  public PluginCommandRQ arguments(Object arguments) {
    this.arguments = arguments;
    return this;
  }

  /**
   * Arbitrary parameters for the command.
   * @return arguments
   */
    @Schema(name = "arguments", description = "Arbitrary parameters for the command.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("arguments")
  public Object getArguments() {
    return arguments;
  }

  public void setArguments(Object arguments) {
    this.arguments = arguments;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PluginCommandRQ pluginCommandRQ = (PluginCommandRQ) o;
    return Objects.equals(this.context, pluginCommandRQ.context) &&
        Objects.equals(this.arguments, pluginCommandRQ.arguments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(context, arguments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PluginCommandRQ {\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    arguments: ").append(toIndentedString(arguments)).append("\n");
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
  
      private PluginCommandRQ instance;
  
      public Builder() {
        this(new PluginCommandRQ());
      }
  
      protected Builder(PluginCommandRQ instance) {
        this.instance = instance;
      }
  
      protected Builder copyOf(PluginCommandRQ value) { 
        this.instance.setContext(value.context);
        this.instance.setArguments(value.arguments);
        return this;
      }
  
        public Builder context(PluginCommandContext context) {
        this.instance.context(context);
        return this;
      }
      
        public Builder arguments(Object arguments) {
        this.instance.arguments(arguments);
        return this;
      }
      
          /**
      * returns a built PluginCommandRQ instance.
      *
      * The builder is not reusable (NullPointerException)
      */
      public PluginCommandRQ build() {
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

