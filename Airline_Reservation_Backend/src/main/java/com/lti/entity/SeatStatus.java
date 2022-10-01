package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seat_Status_Table")
public class SeatStatus {
	
	@Id
	@GeneratedValue
	private int sid;
	private boolean sstatus;
	
//	//starts
//
//		@OneToOne(cascade=CascadeType.ALL)
//		private SeatBooking sb;
//		
//		public SeatBooking getSb() {
//			return sb;
//		}
//		public void setSb(SeatBooking sb) {
//			this.sb = sb;
//		}
//		//ends
//	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public boolean isSstatus() {
		return sstatus;
	}
	public void setSstatus(boolean sstatus) {
		this.sstatus = sstatus;
	}
	
	
//	@Override
//	public String toString() {
//		return "SeatStatus [sid=" + sid + ", sstatus=" + sstatus + ", sb=" + sb + "]";
//	}
	
	
	
	
}	
	