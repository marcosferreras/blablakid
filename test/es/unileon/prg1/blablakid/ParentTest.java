package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	private Parent parent;
	
	@Before
	public void setup() throws BlaException{
		Kids kids = new Kids(3);
		Kid kid = new Kid("Juan");
		kids.add(kid);
		this.parent = new Parent("Carlos",kids);
	}
	
	@Test
	public void getSetNameTest() {
		this.parent.setName("Rodolfo");
		assertEquals("Rodolfo", this.parent.getName());
	}

	
	@Test
	public void builderTest() {
		assertEquals("Carlos",parent.getName());
	}
}