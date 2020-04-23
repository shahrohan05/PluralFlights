package com.pluralflights.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserLoginTest {
	
	@Spy
	private UserDAO userDAO;
	
	private User user = new User("user", "password");
	
	@DisplayName("Verify that the user can login with the same username and password")
	@Test
	void testUserSuccessfulLoging() {
		Mockito.when(userDAO.login(user)).thenReturn(true); // sets the userDAO.login method to return true when called with user with same username and password
		User sameUser = new User("user", "password");
		assertTrue(userDAO.login(sameUser));
	}
	
	
	@DisplayName("Verify that the user cannot login with different username and password")
	@Test
	void testUserUnsuccessfulLogin() {
		//Mockito.when(userDAO.login(user)).thenReturn(true);
		User differentUser = new User("otherUser", "otherPassword");
		
		assertFalse(user.equals(differentUser));
		assertFalse(user.hashCode() == differentUser.hashCode());
		
		assertFalse(userDAO.login(differentUser));
	}
	
	
	@DisplayName("Check if the user is admin")
	@Test
	void checkUserAdmin() {
		User adminUser = new User("admin", "password");
		assertTrue(userDAO.checkAdmin(adminUser)); // this will not work if the UserDAO is @Mock, 
							//but we can change it to @Spy to inject a mock object which will also call real methods, when mock implementation is not provided
	}

}
