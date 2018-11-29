package com.csci360.electionapp.model;

import static org.junit.Assert.*;
import com.csci360.electionapp.Security.AES;

import org.junit.Before;
import org.junit.Test;

public class AESTest {

	private String dob = "January 1, 1960";
	private String dob2 = "June 30, 2000";
	private String dob3 = "Feb 50, 2010";
	
	private String add = "123 Main St";
	private String add2 = "5097 South Avenue";
	private String add3 = "";
	
	private String ssn = "123456789";
	private String ssn2 = "987654321";
	private String ssn3 = "";
	
	
	@Before
	public void setUp() throws Exception {
		
		String edob = AES.encrypt(dob);
		String edob2 = AES.encrypt(dob2);
		String edob3 = AES.encrypt(dob3);
		
		String eadd = AES.encrypt(add);
		String eadd2 = AES.encrypt(add2);
		String eadd3 = AES.encrypt(add3);
		
		String essn = AES.encrypt(ssn);
		String essn2 = AES.encrypt(ssn2);
		String essn3 = AES.encrypt(ssn3);
		
		String ddob = AES.decrypt(edob);
		String ddob2 = AES.decrypt(edob2);
		String ddob3 = AES.decrypt(edob3);
		
		String dadd = AES.decrypt(eadd);
		String dadd2 = AES.decrypt(eadd2);
		String dadd3 = AES.decrypt(eadd3);
		
		String dssn = AES.decrypt(essn);
		String dssn2 = AES.decrypt(essn2);
		String dssn3 = AES.decrypt(essn3);
		
		System.out.println(dob);
		System.out.println(edob);
		System.out.println(ddob);
		
		System.out.println(dob2);
		System.out.println(edob2);
		System.out.println(ddob2);
		
		System.out.println(dob3);
		System.out.println(edob3);
		System.out.println(ddob3);
		
		System.out.println(add);
		System.out.println(eadd);
		System.out.println(dadd);
		
		System.out.println(add2);
		System.out.println(eadd2);
		System.out.println(dadd2);
		
		System.out.println(add3);
		System.out.println(eadd3);
		System.out.println(dadd3);
		
		System.out.println(ssn);
		System.out.println(essn);
		System.out.println(dssn);
		
		System.out.println(ssn2);
		System.out.println(essn2);
		System.out.println(dssn2);
		
		System.out.println(ssn3);
		System.out.println(essn3);
		System.out.println(dssn3);
	}

	@Test
	public void test() {
	
	}

}
