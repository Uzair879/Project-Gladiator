//package com.lti.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import org.springframework.stereotype.Repository;
//
//import com.lti.entity.User;
////CRUD
//@Repository
//public interface UserRepository extends JpaRepository<User, Integer> {
//	User findByEmail(String email);
//	User findById(int u_id);
//
//	
//}
package com.lti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lti.entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Integer>  {

	
	
}
