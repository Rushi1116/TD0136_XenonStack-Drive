
package com.cdac.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Credential;
import com.cdac.dto.Response;
import com.cdac.dto.UserDto;
import com.cdac.entities.User;
import com.cdac.service.UserService;


 @CrossOrigin(origins = "*")
 @RestController 
public class UserController {
 
 @Autowired 
 private UserService userservice ;
  
  @PostMapping("/user/signin")
  public ResponseEntity<?> signin(@RequestBody Credential cred )
  { 
    
    UserDto result=userservice.loginVerification(cred.getEmail(), cred.getPassword());
  System.out.println("email "+ cred.getEmail());
  System.out.println(" pass "+cred.getPassword());
     
  if(result==null)
     {
       return Response.error("user not found"); 
     } 
       return Response.success(result); 
  }
 
 //NT Chnage
  @GetMapping("/users") 
  public @ResponseBody List<User> findAll()
  {
	  System.out.println("jgdfhjg");
	  List<User> u=userservice.findAllUser();
	  return u; 
  }
  
 
 @PostMapping("/user/signup")
 public ResponseEntity<?> signup(@RequestBody UserDto u)
 {
	 System.out.println("in user signup user :"+u);
     UserDto result=userservice.addUser(u); 
      if(result==null)
     {
	   return Response.error("user not added"); 
     } 
        return Response.success(result); 
 }
 
}
 