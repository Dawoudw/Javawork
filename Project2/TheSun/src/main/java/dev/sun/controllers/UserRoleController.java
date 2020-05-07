package dev.sun.controllers;

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

import dev.sun.entities.UserRole;
import dev.sun.services.UserRoleService;

@Controller
@Component
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserRoleController {
	
	@Autowired
	UserRoleService urs;
	
	@ResponseBody
	@RequestMapping(value="/roles", method = RequestMethod.POST)
	public UserRole createUserRole(@RequestBody UserRole userRole) {
		return urs.createUserRole(userRole);
	}
	
	@ResponseBody
	@RequestMapping(value="/roles", method = RequestMethod.PUT)
	public UserRole updateUserRoleById(@RequestBody UserRole userRole) {
		return urs.updateUserRoleById(userRole);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/roles/{id}" , method = RequestMethod.GET)
	public UserRole getUserRoleById(@PathVariable int id) {
		try {
			System.out.println(id);
			UserRole userRole = urs.getUserRoleById(id);
			return userRole;
		} catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find UserRole");
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/roles" , method = RequestMethod.DELETE)
	public boolean deleteUserRole (@RequestBody UserRole userRole) {
		boolean result = urs.deleteUserRole(userRole);
		
		if(result == false ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
		return result;
	}
}

