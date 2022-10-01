//package com.lti.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name ="Admin_Table")
//public class Admin {
//	
//	@Id
//	@SequenceGenerator(name = "userSeqGen", sequenceName = "userSeq", initialValue = 1, allocationSize = 1)
//	@GeneratedValue(generator = "a_id")
//	private int a_id;
//	
//	private String adminname;
//	private String password;
//	private String qus;
//	private String ans;
//	
//	public int getA_id() {
//		return a_id;
//	}
//	public void setA_id(int a_id) {
//		this.a_id = a_id;
//	}
//	public String getadminname() {
//		return adminname;
//	}
//	public void setUsername(String adminname) {
//		this.adminname = adminname;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getQus() {
//		return qus;
//	}
//	public void setQus(String qus) {
//		this.qus = qus;
//	}
//	public String getAns() {
//		return ans;
//	}
//	public void setAns(String ans) {
//		this.ans = ans;
//	}
//	@Override
//	public String toString() {
//		return "User [a_id=" + a_id + ", adminname=" + adminname + ", password=" + password + ", qus=" + qus + ", ans="
//				+ ans + "]";
//	}	
//
//}

package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Table1")
public class Admin {
	@Id
	private long userid;
	private String password;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [userid=" + userid + ", password=" + password + "]";
	}

	
}

