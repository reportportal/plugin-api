/*
 * Copyright 2018 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epam.reportportal.extension.common;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ExtensionPointTest {

	@Test
	public void findByExtensionPositive() {
		Assert.assertThat("Incorrect find by extension",
				ExtensionPoint.findByExtension(ExtensionPoint.BTS.getExtensionClass()).isPresent(),
				CoreMatchers.is(true)
		);
	}

	@Test
	public void findByExtensionNegative() {
		Assert.assertThat("Incorrect find by extension", ExtensionPoint.findByExtension(String.class).isPresent(), CoreMatchers.is(false));
	}
}