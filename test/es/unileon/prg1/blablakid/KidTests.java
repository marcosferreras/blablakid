package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidTests {
	private Kid kid;
	
	@Before
	public void setUp() throws Exception {
		kid = new Kid("Daniel");
		}
	@Test 
	public void testKid() {
		assertEquals("Daniel", kid.getName());
	}
}
