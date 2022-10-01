//package com.lti.service;
//
//import java.util.List;
//
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import com.lti.dao.UserRepository;
//import com.lti.entity.User;
//import com.lti.exceptions.NoUserFoundException;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository uRepo;
//	
//
//	
//	@Transactional //use org.spring.....
//	@Override
//	public User createUser(User u) {
//		return uRepo.save(u);
//	}
//
//	@Override
//	public List<User> listOfUsers() {
//		
//		return uRepo.findAll();
//	}
//
//	@Override
//	public User findUserById(int u_id) throws NoUserFoundException {
//
//		Optional<User> uFind = uRepo.findById(u_id);
//		User user = null;
//		if(uFind.isPresent())
//		{
//			user = uFind.get();
//		}
//		else
//		{
//			throw new NoUserFoundException("User Not Found");
//		}
//		return user;
//		
//	}
//
//	@Override
//	@Transactional
//	public User updateUserById(int u_id, User u) throws NoUserFoundException {
//		Optional<User> uFind = uRepo.findById(u_id);
//		User user = null;
//		if(uFind.isPresent())
//		{
//			//stud = sFind.get();
//			uRepo.save(u);
//		}
//		else
//		{
//			throw new NoUserFoundException("User Not Found");
//		}
//		return u;
//
//
//	}
//	
//	@Override
//	public User deleteUserById(int u_id) throws NoUserFoundException {
//		Optional<User> uFind = uRepo.findById(u_id);
//		User user = null;
//		if(uFind.isPresent())
//		{
//			user = uFind.get();
//			uRepo.delete(user);
//		}
//		else
//		{
//			throw new NoUserFoundException("User Not Found");
//		}
//		return user;
//		
//	}
//
//	@Override
//	public User loginUser(String userName, String password) throws NoUserFoundException {
//		System.out.println("inside loginUser "+userName+" -"+password);
//		// TODO Auto-generated method stub
//		try {
//		User user=uRepo.findByEmail(userName);
//		String passwordFromDb=user.getU_password();
//		if(password.equals(passwordFromDb)) {
//			System.out.println("User with userName found "+userName);
//			return user;
//		}else {
//			System.out.println("Pasword and user name not Matching");
//			//throw new NoUserFoundException("Pasword and user name not Matching");
//			// TO DO throw new expction();
//		}
//		}catch(Exception ex) {
//			throw new NoUserFoundException("User with this userName not found");
//		}
//		return null;
//	}
//
//	@Override
//	public User forgotpassword(String username) throws NoUserFoundException {
//		User user=uRepo.findByEmail(username);
//		return user;
//	}
//
//	@Override
//	public User checkUser(int u_id) {
//		User ufind = uRepo.findById(u_id);
//		User ugot = null;
////		if(ufind.isPresent())
////		{
////			ugot = ufind.get();
////			return ugot;
////		}
////		return ugot;
//		ugot = ufind.
//	}
//	
//	
//
//}
package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.UserRepository;
import com.lti.entity.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository urepo;
	
	@Override
	@Transactional
	public User createUser(User data) {
		return urepo.save(data);
	}

	


	@Override
	public List<User> listOfUsers() {
		
		return urepo.findAll();
	}

	@Override
	public User findUserById(int u_id) {
		Optional<User> uFind = urepo.findById(u_id);
		User user = null;
		if(uFind.isPresent())
		{
			user = uFind.get();
		}

		return user;
		
	}
		


	@Override
	public User checkUser(int u_id) {
		Optional<User> ufind = urepo.findById(u_id);
		User ugot = null;
		if(ufind.isPresent())
		{
			ugot = ufind.get();
			return ugot;
		}
		return ugot;
	
	}

	@Override
	public User updateUserById(int u_id, User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUserById(int u_id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public User forgotpassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
