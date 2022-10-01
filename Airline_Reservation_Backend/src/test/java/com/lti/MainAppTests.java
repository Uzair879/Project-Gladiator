package com.lti;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.AdminRepository;
import com.lti.dao.FlightRepository;
import com.lti.dao.SeatBookingRepository;
import com.lti.dao.UserRepository;
import com.lti.entity.Admin;
import com.lti.entity.Flight;
import com.lti.entity.SeatBooking;
import com.lti.entity.User;
import com.lti.exceptions.NoAdminFoundException;
import com.lti.exceptions.NoFlightFoundException;
import com.lti.exceptions.NoUserFoundException;
import com.lti.service.AdminService;
import com.lti.service.FlightService;
import com.lti.service.SeatBookingService;
import com.lti.service.UserService;

@SpringBootTest
class MainAppTests {

	@Test
	void contextLoads() {
		
	}
	//------------------ADMIN------------------------

		@Autowired
		AdminRepository aRepo;
		
		@Autowired
		AdminService aService;
		
		
		@Test
		public void createAdminTest()
		{
			Admin a = new Admin();
			
			
			a.setUserid(1234);
			a.setPassword("abcd");
			
//			aRepo.save(a);
//			
//			assertNotNull(aRepo.findById("dummy").get());

			
	//BUS
//			aRepo.save(a);
			
			aService.createAdmin(a);
			Assertions.assertTrue(aService.createAdmin(a)instanceof Admin );
			
//			assertNotNull(a.getUserid());//pass 
				
		}
		
		@Test
		public void validateTest() throws NoAdminFoundException
		{	
			Admin a = new Admin();
			
			a.setUserid(1234);
			a.setPassword("abcd");
			
			aRepo.save(a);
			
		//	assertEquals(, aService.validate(a));
		}
		



	//------------------USER------------------------

	@Autowired
	UserRepository uRepo;

	@Autowired
	UserService uService;

	@Test
	public void createUserTest()
	{
		User u = new User();
		
		u.setU_id(1);
		u.setU_title("Ms");
		u.setU_firstname("Tanvi");
		u.setU_lastname("Mehta");
		//u.setU_dOD(20-04-2000);
		u.setEmail("tanvi@gmail.com");
		u.setU_password("tanvi123");
		u.setU_contact("9876543210");
		u.setQus("What is your mothers's name?");
		u.setEmail("Mummy");
		
//		uRepo.save(u);
		uService.createUser(u);
		Assertions.assertTrue(uService.createUser(u)instanceof User );
//		assertNotNull(u.getUser_Id());//pass 
	}

	@Test
	public void listOfUsersTest() 
	{
//		List<User> ulist=uRepo.findAll();
		List<User> ulist=uService.listOfUsers();
		//assertThat(ulist).size().isGreaterThan(0);
	}


	@Test
	public void findUserByIdTest() throws NoUserFoundException {
		User user=uService.findUserById(1);
		assertEquals("Tanvi",user.getU_id());
	}
		

	private void assertEquals(String string, int u_id) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void checkUserTest() throws NoUserFoundException {
		User user=uService.checkUser(1);
		assertEquals("Tanvi",user.getU_id());
	}

	@Test
	public void updateUserByIdTest() throws NoUserFoundException {
		
	User u = new User();
		
		u.setU_id(1);
		u.setU_title("Ms");
		u.setU_firstname("Tanvi");
		u.setU_lastname("Mehta");
		//u.setU_dOD(20-04-2000);
		u.setEmail("tanvi@gmail.com");
		u.setU_password("tanvi123");
		u.setU_contact("9876511111");    //PHONE NUMBER CHANGED
		u.setQus("What is your mothers's name?");
		u.setEmail("Mummy");
		
//		User u=uService.findUserById(1);
//		u.setU_contact("9876511111");

		uService.updateUserById(u.getU_id(),u);
		assertNotEquals("9876543210", uService.findUserById(1).getU_contact());	
	}

	private void assertNotEquals(String string, String u_contact) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void deleteUserByIdTest() throws NoUserFoundException {
//		uRepo.deleteById(108);
		uService.deleteUserById(1);
		//assertThat(uRepo.existsById(1)).isFalse();
		
	}

	//@Test
	//public void forgetpasswordTest() throws NoUserFoundException {
////		uRepo.deleteById(108);
//		uService. forgetpasswordId(1);
//		assertThat(uRepo.existsById(1)).isFalse();
	//	
	//}



	//------------------FLIGHT------------------------


	@Autowired
	FlightRepository fRepo;

	@Autowired
	FlightService fService;

	@Test
	public void createFlightTest()
	{
		Flight f = new Flight();
		
		f.setFlight_id(101);
		f.setFlight_name("Air India");
		f.setFlight_to("Mumbai");
		f.setFlight_from("Delhi");
		f.setFlight_es_price(100);
		f.setFlight_bs_price(500);
		f.setFlight_no_es(50);
		f.setFlight_no_bs(10);
	//	f.setFlight_arrival(10-04-2022);
	//	f.setFlight_departure(11-04-2022);
		f.setFlight_duration(4);
		
		fService.createFlight(f);
		
		Assertions.assertTrue(fService.createFlight(f)instanceof Flight);
		
	}

	@Test
	public void listOfFlightTest() {
		List<Flight> flist=fService.listOfFlights();
		//assertThat(flist).size().isGreaterThan(0);
	}

	private List<User> assertThat(List<Flight> flist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void findFlightByIdTest() throws NoFlightFoundException{
		
		Flight flight=fService.findFlightById(108);
		assertEquals("Air India",flight.getFlight_name());//pass
		
	}


	private void assertEquals(String string, String flight_name) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void findDeleteByIdTest() throws NoFlightFoundException{
		
		fService.deleteFlightById(108);
		//assertThat(fRepo.existsById(208)).isFalse();

	}
//	private Object //assertThat(boolean existsById) 
//	{
//	// TODO Auto-generated method stub
//	return null;
//	}



	//------------------SEAT BOOKING------------------------

@Autowired 
SeatBookingRepository sbRepo;


@Autowired 
SeatBookingService sbService;
@Test
public void createSeatBooking()
{
	 SeatBooking sb = new SeatBooking();
}
	

}


	

