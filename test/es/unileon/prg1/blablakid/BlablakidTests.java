package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlablakidTests {
	private Blablakid blablakid;
	
	@Before
	public void setUp() throws BlaException {
		blablakid = new Blablakid(3);
	}
	@Test (expected = BlaException.class)
	public void testNumOfKidsNegative() throws BlaException {
		new Blablakid(-1);
	}
	@Test
	public void testAddKid() {
		new Kid("Daniel");
	}
}