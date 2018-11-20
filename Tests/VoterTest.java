import static org.junit.Assert.*;

import com.csci360.electionapp.model.Voter;
import org.junit.Before;
import org.junit.Test;

public class VoterTest {

	private Voter test1;
	private Voter test2;
	private Voter test3;
	
	private String firstName = "John";
	private String firstName2 = "Sally";
	private String firstName3 = "123456789012345678901234567890";
	
	private String lastName = "Doe";
	private String lastName2 = "Deer";
	private String lastName3 = "123456789012345678901234567890";
	
	private String dob = "January 1, 1980";
	private String dob2 = "June 30, 1990";
	private String dob3 = "February 60, 2000";
	
	private String ssn = "123456789";
	private String ssn2 = "987645321";
	private String ssn3 = "";
	
	private String address = "123 Main Street";
	private String address2 = "505 South Street";
	private String address3 = "";
	
	private String un = "jd1";
	private String un2 = "1ds";
	private String un3 = "";
	
	private String pw = "abcd1234";
	private String pw2 = "1234abcd";
	private String pw3 = "";
	
	@Before
	public void setUp() throws Exception {
		test1 = new Voter();
		test1.setFirstName(firstName);
		test1.setLastName(lastName);
		test1.setDateOfBirth(dob);
		test1.setSocialSecurityNumber(ssn);
		test1.setAddress(address);
		test1.setUserName(un);
		test1.setPassword(pw);
		
		test2 = new Voter();
		test2.setFirstName(firstName2);
		test2.setLastName(lastName2);
		test2.setDateOfBirth(dob2);
		test2.setSocialSecurityNumber(ssn2);
		test2.setAddress(address2);
		test2.setUserName(un2);
		test2.setPassword(pw2);
		
		test3 = new Voter();
		test3.setFirstName(firstName3);
		test3.setLastName(lastName3);
		test3.setAddress(address3);
		test3.setDateOfBirth(dob3);
		test3.setSocialSecurityNumber(ssn3);
		test3.setUserName(un3);
		test3.setPassword(pw3);
	}

	@Test
	public void testGetFirstName() {
		assertEquals(test1.getFirstName(), firstName);
		assertEquals(test2.getFirstName(), firstName2);
		assertEquals(test3.getFirstName(), firstName3);
	}

	@Test
	public void testGetLastName() {
		assertEquals(test1.getLastName(), lastName);
		assertEquals(test2.getLastName(), lastName2);
		assertEquals(test3.getLastName(), lastName3);
	}

	@Test
	public void testGetDateOfBirth() {
		assertEquals(test1.getDateOfBirth(), dob);
		assertEquals(test2.getDateOfBirth(), dob2);
		assertEquals(test3.getDateOfBirth(), dob3);
	}

	@Test
	public void testGetSocialSecurityNumber() {
		assertEquals(test1.getSocialSecurityNumber(), ssn);
		assertEquals(test2.getSocialSecurityNumber(), ssn2);
		assertEquals(test3.getSocialSecurityNumber(), ssn3);
	}

	@Test
	public void testGetAddress() {
		assertEquals(test1.getAddress(), address);
		assertEquals(test2.getAddress(), address2);
		assertEquals(test3.getAddress(), address3);
	}

	@Test
	public void testGetUserName() {
		assertEquals(test1.getUserName(), un);
		assertEquals(test2.getUserName(), un2);
		assertEquals(test3.getUserName(), un3);
	}

	@Test
	public void testGetPassword() {
		assertEquals(test1.getPassword(), pw);
		assertEquals(test2.getPassword(), pw2);
		assertEquals(test3.getPassword(), pw3);
	}


}
