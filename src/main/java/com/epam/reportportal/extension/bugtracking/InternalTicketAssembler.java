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
package com.epam.reportportal.extension.bugtracking;

import com.epam.reportportal.extension.util.FileNameExtractor;
import com.epam.ta.reportportal.binary.DataStoreService;
import com.epam.ta.reportportal.dao.LogRepository;
import com.epam.ta.reportportal.dao.TestItemRepository;
import com.epam.ta.reportportal.entity.log.Log;
import com.epam.ta.reportportal.filesystem.DataEncoder;
import com.epam.ta.reportportal.ws.model.externalsystem.PostTicketRQ;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Converts REST model into internal domain model representation
 *
 * @author Andrei Varabyeu
 */
@Service
public class InternalTicketAssembler implements Function<PostTicketRQ, InternalTicket> {

	private final LogRepository logRepository;

	private final TestItemRepository itemRepository;

	private final DataStoreService dataStorage;

	private final DataEncoder dataEncoder;

	@Autowired
	public InternalTicketAssembler(LogRepository logRepository, TestItemRepository itemRepository, DataStoreService dataStorage,
			DataEncoder dataEncoder) {
		this.logRepository = logRepository;
		this.itemRepository = itemRepository;
		this.dataStorage = dataStorage;
		this.dataEncoder = dataEncoder;
	}

	@Override
	public InternalTicket apply(PostTicketRQ input) {
		InternalTicket ticket = new InternalTicket();

		ofNullable(input.getFields()).ifPresent(fields -> {
			Multimap<String, String> fieldsMultimap = LinkedListMultimap.create();
			fields.forEach(f -> fieldsMultimap.putAll(f.getId(), f.getValue()));
			ticket.setFields(fieldsMultimap);
		});

		if (input.getIsIncludeLogs() || input.getIsIncludeScreenshots()) {
			List<Log> logs = logRepository.findByTestItemId(input.getTestItemId(),
					0 == input.getNumberOfLogs() ? Integer.MAX_VALUE : input.getNumberOfLogs()
			);

			ticket.setLogs(logs.stream().map(l -> {
				/* Get screenshots if required and they are present */
				if (null != l.getAttachment() && input.getIsIncludeScreenshots()) {
					return new InternalTicket.LogEntry(l.getId(),
							l.getLogMessage(),
							l.getAttachment(),
							FileNameExtractor.extractFileName(dataEncoder, l.getAttachment().getFileId()),
							true,
							input.getIsIncludeLogs()
					);
				}
				/* Forwarding enabled logs boolean if screens only required */
				return new InternalTicket.LogEntry(l.getId(), l.getLogMessage(), input.getIsIncludeLogs());
			}).collect(Collectors.toList()));
		}

		if (input.getIsIncludeComments()) {
			itemRepository.findById(input.getTestItemId())
					.ifPresent(item -> ofNullable(item.getItemResults()
							.getIssue()).ifPresent(issue -> ofNullable(issue.getIssueDescription()).ifPresent(ticket::setComments)));

		}

		if (!CommonPredicates.IS_MAP_EMPTY.test(input.getBackLinks())) {
			ticket.setBackLinks(ImmutableMap.copyOf(input.getBackLinks()));
		}
		return ticket;
	}
}