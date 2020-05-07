package dev.sun.services;

import java.util.List;

import dev.sun.entities.User;

public interface UserService {
	
	User createUser(User user);
	
	User getUserById(int id);
	List<User> getAllUsers();
	User loginUser(String username, String password);
	
	User updateUser(User user);
	
	boolean deleteUser(User user);
}
