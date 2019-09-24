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

package com.epam.reportportal.extension.util;

import com.epam.ta.reportportal.filesystem.DataEncoder;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.nio.file.Paths;

/**
 * Decodes file path encoded by {@link DataEncoder} and extracts file name from it
 *
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class FileNameExtractor {

	@Nullable
	public static String extractFileName(DataEncoder dataEncoder, @Nullable String fileId) {

		if (StringUtils.isBlank(fileId)) {
			return fileId;
		}

		return String.valueOf(Paths.get(dataEncoder.decode(fileId)).getFileName());
	}
}
