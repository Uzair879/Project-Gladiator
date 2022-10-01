package com.lti.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name ="User_Table")
public class User {
	
	@SequenceGenerator(name = "userSeqGen", sequenceName = "userSeq", initialValue = 101, allocationSize = 1)
	@GeneratedValue(generator = "u_id")
	@Id
	private int u_id;
	private String u_title;
	private String u_firstname;
	private String u_lastname;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date u_dOD;
	private String email;
	private String u_password;
	private String u_contact;
	private String qus;
	private String ans;
	
	
//	//changes made start
//		@OneToMany(cascade=CascadeType.ALL)
//		private List<Flight> flight_list=new ArrayList<Flight>();
//	// change on payment
//		
//		//end1
//		public List<Flight> getFlight_list() {
//			return flight_list;
//		}
//		public void setFlight_list(List<Flight> flight_list) {
//			this.flight_list = flight_list;
//		}
//		// end

	
	//Getters & Setters
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_title() {
		return u_title;
	}
	public void setU_title(String u_title) {
		this.u_title = u_title;
	}
	public String getU_firstname() {
		return u_firstname;
	}
	public void setU_firstname(String u_firstname) {
		this.u_firstname = u_firstname;
	}
	public String getU_lastname() {
		return u_lastname;
	}
	public void setU_lastname(String u_lastname) {
		this.u_lastname = u_lastname;
	}

	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_contact() {
		return u_contact;
	}
	public void setU_contact(String u_contact) {
		this.u_contact = u_contact;
	}
	public Date getU_dOD() {
		return u_dOD;
	}
	public void setU_dOD(Date u_dOD) {
		this.u_dOD = u_dOD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQus() {
		return qus;
	}
	public void setQus(String qus) {
		this.qus = qus;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
//	@Override
//	public String toString() {
//		return "User [u_id=" + u_id + ", u_title=" + u_title + ", u_firstname=" + u_firstname + ", u_lastname="
//				+ u_lastname + ", u_dOD=" + u_dOD + ", email=" + email + ", u_password=" + u_password + ", u_contact="
//				+ u_contact + ", qus=" + qus + ", ans=" + ans + ", flight_list=" + flight_list + "]";
//	}
	

}
