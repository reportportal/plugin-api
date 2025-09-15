/*
 * Copyright (C) 2025 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.reportportal.extension;

import static org.springframework.data.util.Predicates.isTrue;

import com.epam.reportportal.api.model.PluginCommandContext;
import com.epam.reportportal.api.model.PluginCommandRQ;
import com.epam.reportportal.rules.commons.validation.BusinessRule;
import com.epam.reportportal.rules.exception.ErrorType;
import com.epam.ta.reportportal.commons.Predicates;


public abstract class AbstractContextBasedCommand<T> implements CommonPluginCommand<T> {

  private static final String INVALID_SCOPE_PARAMETERS_ERROR_MESSAGE = "Invalid context scope parameters.";

  protected abstract void validateRole(PluginCommandContext commandContext);

  protected abstract T invokeCommand(PluginCommandRQ pluginCommandRq);

  @Override
  public T executeCommand(PluginCommandRQ pluginCommandRq) {
    validateContextScope(pluginCommandRq.getContext());
    validateRole(pluginCommandRq.getContext());
    return invokeCommand(pluginCommandRq);
  }

  private void validateContextScope(PluginCommandContext context) {
    switch (context.getScope()) {
      case GLOBAL -> {
      }
      case ORGANIZATION -> BusinessRule.expect(context.getOrgId(), Predicates.notNull())
          .verify(ErrorType.BAD_REQUEST_ERROR, INVALID_SCOPE_PARAMETERS_ERROR_MESSAGE);
      case PROJECT -> BusinessRule.expect(context.getProjectId() != null && context.getOrgId() == null, isTrue())
          .verify(ErrorType.BAD_REQUEST_ERROR, INVALID_SCOPE_PARAMETERS_ERROR_MESSAGE);
      case null -> {
      }
    }
  }

}
