//package com.lti.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//import org.springframework.stereotype.Repository;
//
//import com.lti.entity.Admin;
////CRUD
//@Repository
//public interface AdminRepository extends JpaRepository<Admin, Integer> {
//
//	Admin findByAdminname(String adminname);
//}
package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}

