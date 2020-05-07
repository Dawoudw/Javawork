package dev.sun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.sun.entities.User;
import dev.sun.repositories.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository ur;
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) ur.findAll();
	}
	
	@Override
	public User createUser(User user) {
		user.setUserId(0);
		user = ur.save(user);
		return user;
	}
	
	@Override
	public User getUserById(int id) {
		return ur.findById(id).get();
	}
	
	
	@Override
	public User loginUser(String username, String password) {
		User user = ur.findByUserName(username);
		String userPassword = user.getPassword();
		if(userPassword.equals(password)) {
			return user;
		}
		else {
			return null;	// Return null when the password is unmatched
		}
	}
	
	
	@Override
	public User updateUser(User user) {
		ur.save(user);
		return user;
	}
	
	
	@Override
	public boolean deleteUser(User user) {
		ur.delete(user);
		return true;
	}

}
