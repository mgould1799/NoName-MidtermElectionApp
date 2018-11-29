

import com.csci360.electionapp.model.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VoterStorageTest {

	@Before
	public void setUp() throws Exception {
		Voter test1 = new Voter("John", "Doe", "dateofbirth", "ssn", "address", "userName", "password");
	}

	@Test
	public final void testStoreVoter() {
		Voter test1 = new Voter("John", "Doe", "dateofbirth", "ssn", "address", "userName", "password");
		VoterStorage.storeVoter(test1);
		
		Voter test2 = new Voter("Sally", "Deer", "June 30, 1960", "123456789", "123 Main St", "sDeer60", "deerjune");
		VoterStorage.storeVoter(test2);
	}

}
