import com.csci360.electionapp.model.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VoterCheckTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testIsUserNameTaken() {
		Voter test1 = new Voter("John", "Doe", "dateofbirth", "ssn", "address", "userName", "password");
		//Voter test2 = new Voter("Sally", "Deer", "June 30, 1960", "123456789", "123 Main St", "sDeer60", "deerjune");
		
		assertEquals(VoterCheck.isUserNameTaken(test1), true);
		//assertEquals(VoterCheck.isUserNameTaken(test2), true);
		
	}

	@Test
	public final void testVerifyUserName() {
		Voter test1 = new Voter("John", "Doe", "dateofbirth", "ssn", "address", "userName", "password");
		//Voter test2 = new Voter("Sally", "Deer", "June 30, 1960", "123456789", "123 Main St", "sdeer60", "deerjune");
		
		assertEquals(VoterCheck.verifyUserName(test1.getUserName()), true);
		//assertEquals(VoterCheck.verifyUserName(test2.getUserName()), true);
		
	}

	@Test
	public final void testVerifyPassword() {
		Voter test1 = new Voter("John", "Doe", "dateofbirth", "ssn", "address", "userName", "password");
		//Voter test2 = new Voter("Sally", "Deer", "June 30, 1960", "123456789", "123 Main St", "sDeer60", "deerjune");
		
		assertEquals(VoterCheck.verifyPassword(test1.getPassword()), true);
		//assertEquals(VoterCheck.verifyPassword(test2.getPassword()), true);
		
		
	}

}
