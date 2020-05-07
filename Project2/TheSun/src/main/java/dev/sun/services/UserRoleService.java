package dev.sun.services;


import dev.sun.entities.UserRole;

public interface UserRoleService {

	UserRole createUserRole(UserRole userRole);
	UserRole updateUserRoleById(UserRole userRole);
	UserRole getUserRoleById(int id);
	boolean deleteUserRole(UserRole userRole);
	
	
}
