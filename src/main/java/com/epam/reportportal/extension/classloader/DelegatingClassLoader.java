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

package com.epam.reportportal.extension.classloader;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Service
public class DelegatingClassLoader extends ClassLoader {

	private final Map<String, ClassLoader> delegates;

	public DelegatingClassLoader() {
		this.delegates = new HashMap<>();
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		try {
			return super.loadClass(name);
		} catch (ClassNotFoundException exc) {
			for (ClassLoader classLoader : delegates.values()) {
				try {
					return classLoader.loadClass(name);
				} catch (ClassNotFoundException e) {
					//let another class loader try
				}
			}
			throw exc;
		}

	}

	public void addLoader(String key, ClassLoader classLoader) {
		delegates.put(key, classLoader);
	}

	public void removeLoader(String key) {
		delegates.remove(key);
	}
}
