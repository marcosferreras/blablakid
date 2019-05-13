package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTests {
	private Parent parent;
	
	@Before
	public void setup() {
		Kids kids = new Kids(3);
		Kid kid = new Kid("Juan");
		kids.add(kid);
		Parent parent = new Parent("Carlos",kids);
	}
	
	@Test
	public void getSetNameTest() {
		parent.setName("Rodolfo");
		assertEquals("Rodolfo", parent.getName());
	}
	
	@Test
	public void getSetKid() {
		Kid kid = new Kid("Juan Carlos");
		parent.setHijo(Kid,2);
		assertEquals(kid.getName(),parent.getHijo(2).getName());
	}
	
	@Test
	public void constructorTest() {
		assertEquals("Rodolfo",parent.getName());
		assertEquals("Juan Carlos",parent.getHijo(1).getName();)
	}
}