package dev.sun.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dev.sun.entities.User;
import dev.sun.entities.UserRole;
import dev.sun.services.UserService;
import dev.sun.services.UserServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = dev.sun.app.TheSunApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTests {

	@Autowired
	UserServiceImpl us;

	@Test
	@Order(1)
	void createUser() {
		UserRole userRole = new UserRole();
		userRole.setRoleId(6);
		userRole.setRoleTitle("Customer");

		User user1 = new User();
		user1.setUserId(0);
		user1.setUserName("Jian2");
		user1.setPassword("j123");
		user1.setUserRole(userRole);

		System.out.println(us.createUser(user1));
	}

	@Test
	@Order(3)
	void getUserById() {
		int id = 4;
		System.out.println(us.getUserById(id));
	}

	@Test
	@Order(2)
	void getAllUsers() {
		System.out.println(us.getAllUsers());
	}

	@Test
	@Order(4)
	void loginUser() {
		String username1 = "Jian";
		String password1 = "j1234";
		User user2 = us.loginUser(username1, password1);
		System.out.println(user2);
	}

	@Test
	@Order(5)
	void updateUser() {
		UserRole userRole = new UserRole();
		userRole.setRoleId(6);
		userRole.setRoleTitle("Customer");

		User user3 = new User();
		user3.setUserId(4);
		user3.setUserName("jian");
		user3.setPassword("j321");
		user3.setUserRole(userRole);

		System.out.println(us.updateUser(user3));
	}

	@Test
	@Order(6)
	void deleteUser() {
		UserRole userRole = new UserRole();
		userRole.setRoleId(6);
		userRole.setRoleTitle("Customer");

		User user4 = new User();
		user4.setUserId(4);
		user4.setUserName("jian");
		user4.setPassword("j321");
		user4.setUserRole(userRole);

		us.deleteUser(user4);
	}
}
