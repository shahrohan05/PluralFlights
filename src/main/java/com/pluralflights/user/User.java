package com.pluralflights.user;

import java.util.Objects;

public class User {

	private String username;
	private String password;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		User otherUser = (User) obj;
		return otherUser.getUsername().equals(this.username) && otherUser.getPassword().equals(this.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, password);
	}

}
