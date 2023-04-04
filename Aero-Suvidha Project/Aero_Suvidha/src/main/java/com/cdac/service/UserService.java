package com.cdac.service;

import java.util.List;

import com.cdac.dto.UserDto;
import com.cdac.entities.User;

public interface UserService {

	public UserDto loginVerification(String Email,String password);
	
	public List<User> findAllUser();
	
	public UserDto addUser(UserDto userdto);

}
