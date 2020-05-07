package dev.sun.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import dev.sun.entities.User;
import dev.sun.services.UserService;

@Controller
@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService us;
	
	@ResponseBody
	@RequestMapping(value = "/users" , method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "/users/{id}" , method = RequestMethod.GET)
	public User getUserById(@PathVariable int id) {
		try {
			return us.getUserById(id);
		}catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/users" , method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return us.createUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/users" , method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return us.updateUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/users" , method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User user) {
		boolean result = us.deleteUser(user);
		if(result == false)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@RequestMapping(value = "/users/login", method = RequestMethod.GET)
	public User loginUser(@RequestBody User user) {
		user = us.loginUser(user.getUserName(), user.getPassword());
		if(user == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		else {
			return user;
		}
	}
}
