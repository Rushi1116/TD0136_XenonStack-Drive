package com.cdac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.UserDao;
import com.cdac.dto.DtoEntityConverter;
import com.cdac.dto.UserDto;
import com.cdac.entities.User;
@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	 DtoEntityConverter convertor;
	
	
	@Override
	public UserDto loginVerification(String Email, String password) {
		          
	       User user = userdao.findByEmail(Email);
	       System.out.println("userrrr  "  +user);
	       if(user!=null)
	       {
		      if(password.equalsIgnoreCase(user.getPassword()))
		       {
			   UserDto userdto= convertor.convertToUserDto(user);
			      userdto.setPassword("******");
			      System.out.println("userdtoooo  "  +userdto);
			   return userdto ;
		       }
	       }
		   return null;
  }


	@Override
	public List<User> findAllUser() {
		
		return userdao.findAll();
	}


	@Override
	public UserDto addUser(UserDto userdto) {
		System.out.println("userdto  "+userdto);
		//convert into userentity
		User u=convertor.convertToUserEntity(userdto);
	    System.out.println(u);
		//dao calling---<S extends T> S save(S entity);
		User us=userdao.save(u);
		//convert into userdto
		userdto =convertor.convertToUserDto(us);
		userdto.setPassword("******");
		return userdto;
	}

}
