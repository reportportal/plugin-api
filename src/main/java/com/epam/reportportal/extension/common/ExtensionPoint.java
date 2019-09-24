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
package com.epam.reportportal.extension.common;

import com.epam.reportportal.extension.bugtracking.BtsExtension;
import com.epam.reportportal.extension.ReportPortalExtensionPoint;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enumeration with all available extension points
 *
 * @author Andrei Varabyeu
 */
public enum ExtensionPoint {
	BTS(BtsExtension.class),
	REPORT_PORTAL(ReportPortalExtensionPoint.class);

	private Class<? extends org.pf4j.ExtensionPoint> extensionClass;

	ExtensionPoint(Class<? extends org.pf4j.ExtensionPoint> extension) {
		this.extensionClass = extension;
	}

	public Class<? extends org.pf4j.ExtensionPoint> getExtensionClass() {
		return extensionClass;
	}

	public static Optional<ExtensionPoint> findByExtension(Class<?> clazz) {
		return Arrays.stream(values()).filter(it -> it.extensionClass.isAssignableFrom(clazz)).findAny();
	}
}
