package dev.sun.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.sun.entities.UserRole;
import dev.sun.repositories.UserRoleRepository;

@Component
@Service
public class UserRoleServiceImpl  implements UserRoleService{


	@Autowired
	UserRoleRepository urr;

	@Override
	public UserRole createUserRole(UserRole userRole) {
		return urr.save(userRole);
	}

	@Override
	public UserRole updateUserRoleById(UserRole userRole) {
		UserRole userFromDb = urr.findById(userRole.getRoleId()).get();
		userFromDb.setRoleTitle(userRole.getRoleTitle());; 
		return urr.save(userFromDb);
	}

	@Override
	public UserRole getUserRoleById(int id) {
		return urr.findById(id).get();
	}

	@Override
	public boolean deleteUserRole(UserRole userRole) {
		

		urr.delete(userRole);
		return true;
	}



}
