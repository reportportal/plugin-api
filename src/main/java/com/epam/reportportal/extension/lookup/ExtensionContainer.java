package com.epam.reportportal.extension.lookup;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ExtensionContainer {

	private final Map<String, Object> extensions;

	public ExtensionContainer() {
		this.extensions = new LinkedHashMap<>();
	}

	public void add(String key, Object extension) {
		extensions.put(key, extension);
	}

	public void remove(String key) {
		extensions.remove(key);
	}

	public <T> T get(String key) {
		return (T) extensions.get(key);
	}

}
