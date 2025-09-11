package com.epam.reportportal.extension;

import com.epam.reportportal.api.model.PluginCommandContext;
import com.epam.reportportal.api.model.PluginCommandRQ;
import com.epam.ta.reportportal.entity.integration.Integration;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public abstract class AbstractContextBasedCommand<T> implements PluginCommand<T> {

  protected abstract void validateRole(PluginCommandContext commandContext);

  protected abstract T invokeCommand(Integration integration, PluginCommandRQ pluginCommandRq);

  @Override
  public T executeCommand(Integration integration, PluginCommandRQ pluginCommandRq) {
    validateRole(pluginCommandRq.getContext());
    return invokeCommand(integration, pluginCommandRq);
  }

}
