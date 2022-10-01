package com.lti.controllers;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import com.lti.entity.User;
import com.lti.exceptions.NoUserFoundException;
import com.lti.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService uService;
	
	//http:localhost:8088/students
	//@RequestMapping(method=RequestMethod.GET)
	//get the User list from server to postman client
	@GetMapping("/user")
	public List<User> getAllUsers()
	{
		return uService.listOfUsers();
	}
	
	@GetMapping("/user/{u_id}")
	public User getUserById(@PathVariable("u_id") int u_id) throws NoUserFoundException 
	{
		return uService.findUserById(u_id);
	}
	
	@PostMapping("/user")
	public User addUser( @RequestBody User u)
	{
		return uService.createUser(u);
	}
	
	@GetMapping("/validateuser/{u_id}")
	public User checkUser( @PathVariable("u_id") int u_id)
	{
		return uService.checkUser(u_id);
	}
	
	@PutMapping("/user/{u_id}")
	public User modifyUser(@PathVariable("u_id") int u_id, @RequestBody User u) throws NoUserFoundException
	{
		return uService.updateUserById(u_id, u);
	}
	
	@DeleteMapping("/user/{u_id}")
	public User removeUser(@PathVariable("u_id") int u_id) throws NoUserFoundException
	{
		return uService.deleteUserById(u_id);
	}
	
//	@GetMapping("/user/{userName}/{password}/login")
//	public User loginUser(@PathVariable String userName, @PathVariable String password) throws NoUserFoundException{
//		System.out.println(" userName "+userName+" password "+password);
//		return uService.loginUser(UriUtils.decode( userName, "UTF-8"), UriUtils.decode( password, "UTF-8"));
//	}
//	@GetMapping("/user/{username}/forgotpassword")
//	public User forgotpassword(@PathVariable String username) throws NoUserFoundException
//	{
//		System.out.println("username"+username);
//		return uService.forgotpassword(username);
//	}
	
}
