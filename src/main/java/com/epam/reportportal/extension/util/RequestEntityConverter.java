/*
 * Copyright 2021 EPAM Systems
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
package com.epam.reportportal.extension.util;

import com.epam.reportportal.rules.commons.validation.Suppliers;
import com.epam.reportportal.rules.exception.ReportPortalException;
import com.epam.reportportal.rules.exception.ErrorType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class RequestEntityConverter {

	private final ObjectMapper objectMapper;

	public RequestEntityConverter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public <T> T getEntity(String key, Map<String, Object> params, Class<T> clazz) {
		return ofNullable(params.get(key)).map(entity -> {
			try {
				return objectMapper.readValue(objectMapper.writeValueAsString(entity), clazz);
			} catch (JsonProcessingException e) {
				throw new ReportPortalException(ErrorType.BAD_REQUEST_ERROR, e.getMessage());
			}
		})
				.orElseThrow(() -> new ReportPortalException(ErrorType.BAD_REQUEST_ERROR,
						Suppliers.formattedSupplier("Parameter '{}' was not provided", key).get()
				));
	}
}
