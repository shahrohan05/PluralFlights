package com.pluralflights.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

	/*Not to be used*/
	private Map<String, String> registeredUsers = new HashMap<String, String>();

	/*NOT to be tested*/
	public boolean login(User user) {
		String username = user.getUsername();
		String password = user.getPassword();

		return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
	}

	
	public boolean checkAdmin(User user) {
		return user.getUsername().equals("admin");
	}

}
