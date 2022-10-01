//package com.lti.controllers;
//
//import java.util.List;
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriUtils;
//
//import com.lti.entity.Admin;
//import com.lti.exceptions.NoAdminFoundException;
//import com.lti.service.AdminService;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//public class AdminController {
//	
//	@Autowired
//	private AdminService aService;
//	
//	//http:localhost:8088/students
//	//@RequestMapping(method=RequestMethod.GET)
//	//get the User list from server to postman client
//	@GetMapping("/admin")
//	public List<Admin> getAllAdmins()
//	{
//		return aService.listOfAdmins();
//	}
//	
//	@GetMapping("/admin/{a_id}")
//	public Admin getUserById(@PathVariable("a_id") int a_id) throws NoAdminFoundException 
//	{
//		return aService.findAdminById(a_id);
//	}
//	@PostMapping("/admin")
//	public Admin addAdmin( @RequestBody Admin a)
//	{
//		return aService.createAdmin(a);
//	}
//	@PutMapping("/admin/{a_id}")
//	public Admin upadteAdmin(@PathVariable("a_id") int a_id, @RequestBody Admin a) throws NoAdminFoundException
//	{
//		return aService.updateAdminById(a_id, a);
//	}
//	
//	
//	@GetMapping("/admin/{adminName}/{password}/login")
//	public Admin loginAdmin(@PathVariable String adminName, @PathVariable String password) throws NoAdminFoundException{
//		System.out.println(" adminName "+adminName+" password "+password);
//		return aService.loginAdmin(UriUtils.decode( adminName, "UTF-8"), UriUtils.decode( password, "UTF-8"));
//	}
//	@GetMapping("/admin/{adminname}/forgotpassword")
//	public Admin forgotpassword(@PathVariable String adminname) throws NoAdminFoundException
//	{
//		System.out.println("adminname"+adminname);
//		return aService.forgotpassword(adminname);
//	}
//	
//}

package com.lti.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;

import com.lti.exceptions.NoAdminFoundException;
import com.lti.service.AdminService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminLoginController {

	@Autowired                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	 private AdminService as;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	
	@PostMapping("/adminregister")
	public Admin addAdmin(@RequestBody Admin al) {
		return as.createAdmin(al);
	}
	
	@GetMapping("/adminlogin/{userid}")
	public Admin validateAdmin(@PathVariable("userid") long userid) throws NoAdminFoundException {
		return as.validate(userid);
	}
	
}
