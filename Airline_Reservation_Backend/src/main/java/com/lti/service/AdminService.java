package com.lti.service;
//
//import java.util.List;
//
//import com.lti.entity.Admin;
//import com.lti.exceptions.NoAdminFoundException;
//
//public interface AdminService {
//	
//	public Admin createAdmin(Admin a);
//
//	public List<Admin> listOfAdmins();
//	
//	public Admin findAdminById(int a_id) throws NoAdminFoundException;
//
//	public Admin updateAdminById(int a_id,Admin a) throws NoAdminFoundException;
//	
//	public Admin loginAdmin(String adminName, String password) throws NoAdminFoundException;
//	
//	public Admin forgotpassword(String adminname) throws NoAdminFoundException;
//	
//}

import com.lti.entity.Admin;
import com.lti.exceptions.NoAdminFoundException;

public interface AdminService{
	public Admin createAdmin(Admin al);
	public Admin validate(long userid) throws NoAdminFoundException;
}
