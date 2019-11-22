package com.audelia.backend.loginregistration.loginregistration.security.model;


import com.audelia.backend.loginregistration.loginregistration.util.enums.UserType;

public class AuthenticationResponse {

	private UserType userType;
	private Object object;
	private String token;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token) {
		this.setToken(token);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
