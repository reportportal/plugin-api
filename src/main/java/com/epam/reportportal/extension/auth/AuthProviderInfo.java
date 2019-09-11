package com.epam.reportportal.extension.auth;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public abstract class AuthProviderInfo {
	private String button;

	public AuthProviderInfo(String button) {
		this.button = button;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}
}
