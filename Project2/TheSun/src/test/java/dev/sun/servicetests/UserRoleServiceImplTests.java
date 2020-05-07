package dev.sun.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.sun.entities.UserRole;
import dev.sun.services.UserRoleServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = dev.sun.app.TheSunApplication.class)
class UserRoleServiceImplTests {
	
	@Autowired
	UserRoleServiceImpl urs;

	@Test
	void createUserRole() {
		UserRole userRole = new UserRole(0, "Testing");
		System.out.println(urs.createUserRole(userRole));
	}
	
	@Test
	public void getUserRoleById() {
		System.out.println(urs.getUserRoleById(7));
	}
	
	@Test
	public void updateUserRole() {
		UserRole userRole = urs.getUserRoleById(7);
		userRole.setRoleTitle("Testing Update Method");
	}
	
	@Test
	public void deleteUserRole() {
		UserRole userRole = urs.getUserRoleById(7);
		System.out.println(urs.deleteUserRole(userRole));
	}

}
