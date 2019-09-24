/*
 * Copyright 2019 EPAM Systems
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

package com.epam.reportportal.extension.bugtracking;

import com.epam.ta.reportportal.entity.integration.IntegrationParams;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author <a href="mailto:andrei_varabyeu@epam.com">Andrei Varabyeu</a>
 */
public enum BtsConstants {
	PROJECT("project"),
	URL("url"),
	OAUTH_ACCESS_KEY("oauthAccessKey"),
	TYPE("btsType"),
	DEFECT_FORM_FIELDS("defectFormFields"),
	USER_NAME("username"),
	PASSWORD("password"),
	AUTH_TYPE("authType");

	private final String name;

	BtsConstants(String name) {
		this.name = name;
	}

	public <T> Optional<T> getParam(IntegrationParams params, Class<T> type) {
		return Optional.ofNullable(params.getParams().get(this.name)).map(type::cast);
	}

	public <T> Optional<Object> getParam(IntegrationParams params) {
		return Optional.ofNullable(params.getParams().get(this.name));
	}

	public void setParam(IntegrationParams params, Object value) {
		if (null == params.getParams()) {
			params.setParams(new HashMap<>());
		}
		params.getParams().put(this.name, value);
	}
}