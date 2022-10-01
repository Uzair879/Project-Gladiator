//package com.lti.service;
//
//import java.util.List;
//
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.lti.dao.AdminRepository;
//import com.lti.entity.Admin;
//import com.lti.exceptions.NoAdminFoundException;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//
//	@Autowired
//	private AdminRepository aRepo;
//	
//	@Transactional //use org.spring.....
//	@Override
//	public Admin createAdmin(Admin a) {
//	
//		return aRepo.save(a);
//	}
//
//	@Override
//	public List<Admin> listOfAdmins() {
//		
//		return aRepo.findAll();
//	}
//
//	@Override
//	public Admin findAdminById(int a_id) throws NoAdminFoundException {
//
//		Optional<Admin> aFind = aRepo.findById(a_id);
//		Admin admin = null;
//		if(aFind.isPresent())
//		{
//			admin = aFind.get();
//		}
//		else
//		{
//			throw new NoAdminFoundException("Admin Not Found");
//		}
//		return admin;
//		
//	}
//
//	@Override
//	@Transactional
//	public Admin updateAdminById(int a_id, Admin a) throws NoAdminFoundException {
//		Optional<Admin> aFind = aRepo.findById(a_id);
//		Admin admin = null;
//		if(aFind.isPresent())
//		{
//			//stud = sFind.get();
//			aRepo.save(a);
//		}
//		else
//		{
//			throw new NoAdminFoundException("Admin Not Found");
//		}
//		return a;
//
//
//	}
//	
//
//
//	@Override
//	public Admin loginAdmin(String adminName, String password) throws NoAdminFoundException {
//		System.out.println("inside loginUser "+adminName+" -"+password);
//		// TODO Auto-generated method stub
//		try {
//		Admin admin=aRepo.findByAdminname(adminName);
//		String passwordFromDb=admin.getPassword();
//		if(password.equals(passwordFromDb)) {
//			System.out.println("Admin with userName found "+adminName);
//			return admin;
//		}else {
//			System.out.println("Pasword and user name not Matching");
//			//throw new NoUserFoundException("Pasword and user name not Matching");
//			// TO DO throw new expction();
//		}
//		}catch(Exception ex) {
//			throw new NoAdminFoundException("Admin with this userName not found");
//		}
//		return null;
//	}
//
//	@Override
//	public Admin forgotpassword(String adminname) throws NoAdminFoundException {
//		Admin admin=aRepo.findByAdminname(adminname);
//		return admin;
//	}
//	
//	
//
//}
package com.lti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminRepository;
import com.lti.entity.Admin;
import com.lti.exceptions.NoAdminFoundException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository arepo;

	@Override
	@Transactional
	public Admin createAdmin(Admin al) {

		return arepo.save(al);
	}

	@Override
	public Admin validate(long userid) throws NoAdminFoundException{
		long uid=userid;
		Optional<Admin> alFind = arepo.findById(uid);
		Admin alGot = null;
		if(alFind.isPresent()) {
			alGot= alFind.get();
		}                             
		else{
			throw new NoAdminFoundException("Admin Not Present in Database.");
		}
		return alGot;
		
	}

}
