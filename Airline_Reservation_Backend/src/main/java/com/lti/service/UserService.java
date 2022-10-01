//package com.lti.service;
//
//import java.util.List;
//
//
//import com.lti.entity.User;
//import com.lti.exceptions.NoUserFoundException;
//
//public interface UserService {
//	
//	public User createUser(User u);
//
//	public List<User> listOfUsers();
//	
//	public User findUserById(int u_id) throws NoUserFoundException;
//
//	public User updateUserById(int u_id,User u) throws NoUserFoundException;
//	
//	public User deleteUserById(int u_id) throws NoUserFoundException;
//	
//	public User loginUser(String userName, String password) throws NoUserFoundException;
//	
//	public User forgotpassword(String username) throws NoUserFoundException;
//
//	User checkUser(int u_id);

	
	
//}
package com.lti.service;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.lti.entity.User;


public interface UserService {

	public User createUser(User data);

	public List<User> listOfUsers();

	public User findUserById(int u_id);

	public User checkUser(int u_id);

	public User updateUserById(int u_id, User u);

	public User deleteUserById(int u_id);

	public User forgotpassword(String username); 
	
}
